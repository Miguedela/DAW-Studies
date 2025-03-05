<?php

use App\Http\Controllers\ProfileController;

use Illuminate\Support\Facades\Route;
use App\Http\Controllers\TractorController;

// Redirigir a tractores.index después de iniciar sesión
Route::get('/', function () {
    return redirect()->route('tractores.index');
});

Route::get('/dashboard', function () {
    return redirect()->route('tractores.index');
})->middleware(['auth', 'verified'])->name('dashboard');

// Route::get('/', function () {
//     return view('welcome');
// });

// Route::get('/dashboard', function () {
//     return view('dashboard');
// })->middleware(['auth', 'verified'])->name('dashboard');

// Rutas para tractores
Route::middleware('auth')->group(function () {
    Route::get('/tractores', [TractorController::class, 'index'])->name('tractores.index');
    Route::get('/tractores/create', [TractorController::class, 'create'])->name('tractores.create');
    Route::post('/tractores', [TractorController::class, 'store'])->name('tractores.store');
    Route::get('/tractores/{id}/edit', [TractorController::class, 'edit'])->name('tractores.edit');
    Route::put('/tractores/{id}', [TractorController::class, 'update'])->name('tractores.update');
    Route::delete('/tractores/{id}', [TractorController::class, 'destroy'])->name('tractores.destroy');
});

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

require __DIR__ . '/auth.php';

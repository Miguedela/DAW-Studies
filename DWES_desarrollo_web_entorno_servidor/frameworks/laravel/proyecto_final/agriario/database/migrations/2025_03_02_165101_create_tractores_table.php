<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration {
    public function up(): void
    {
        Schema::create('tractores', function (Blueprint $table) {
            $table->id();
            $table->string('nombre');
            $table->year('anio_fabricacion');
            $table->decimal('precio_mercado', 10, 2);
            $table->integer('potencia'); // En HP o kW según lo que necesites
            $table->text('descripcion')->nullable();
            $table->string('imagen')->nullable(); // Guardará la ruta de la imagen
            $table->timestamps();
        });
    }

    public function down(): void
    {
        Schema::dropIfExists('tractores');
    }
};

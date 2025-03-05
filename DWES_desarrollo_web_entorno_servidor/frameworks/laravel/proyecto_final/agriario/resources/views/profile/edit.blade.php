@extends('layouts.app')

@section('content')
    <div class="container mt-5">
        <div class="text-center mb-4">
            <h2 class="fw-semibold text-gray-800 dark:text-gray-200">Perfil</h2>
        </div>

        <h1 class="text-center text-gray-800 dark:text-gray-200">¡Hola! Esta es la página de perfil</h1>
        <!-- Línea temporalmente agregada -->

        <div class="row justify-content-center mt-4">
            <div class="col-md-6 mb-4">
                <div class="card shadow-sm p-4 bg-gray-100 dark:bg-gray-700 text-gray-800 dark:text-gray-200 border-0">
                    <div class="card-body">
                        @include('profile.partials.update-profile-information-form')
                    </div>
                </div>
            </div>

            <div class="col-md-6 mb-4">
                <div class="card shadow-sm p-4 bg-gray-100 dark:bg-gray-700 text-gray-800 dark:text-gray-200 border-0">
                    <div class="card-body">
                        @include('profile.partials.update-password-form')
                    </div>
                </div>
            </div>

            <div class="col-md-6 mb-4">
                <div class="card shadow-sm p-4 bg-gray-100 dark:bg-gray-700 text-gray-800 dark:text-gray-200 border-0">
                    <div class="card-body">
                        @include('profile.partials.delete-user-form')
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
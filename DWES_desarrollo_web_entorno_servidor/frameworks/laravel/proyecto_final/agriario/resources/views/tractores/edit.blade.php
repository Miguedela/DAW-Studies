@extends('layouts.app')

@section('content')
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow-sm bg-dark-subtle text-dark">
                    <div class="card-header text-center">
                        <h1 class="mb-0 text-center text-black fw-bolder fs-1">Editar Tractor</h1>
                    </div>
                    <div class="card-body">
                        @if(isset($tractor))
                            <p>Tractor ID: {{ $tractor->id }}</p>
                        @else
                            <p>Error: El objeto tractor no está definido.</p>
                        @endif

                        <form action="{{ route('tractores.update', $tractor->id) }}" method="POST" enctype="multipart/form-data">
                            @csrf
                            @method('PUT')

                            <div class="mb-3 form-floating">
                                <input type="text" class="form-control rounded-2" id="nombre" name="nombre" value="{{ $tractor->nombre }}" required>
                                <label for="nombre" class="form-label">Nombre</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="number" class="form-control rounded-2" id="anio_fabricacion" name="anio_fabricacion"
                                    value="{{ $tractor->anio_fabricacion }}" required>
                                <label for="anio_fabricacion" class="form-label">Año de fabricación</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="number" class="form-control rounded-2" id="precio_mercado" name="precio_mercado"
                                    value="{{ $tractor->precio_mercado }}" step="0.01" required>
                                <label for="precio_mercado" class="form-label">Precio de mercado</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="number" class="form-control rounded-2" id="potencia" name="potencia" value="{{ $tractor->potencia }}"
                                    required>
                                <label for="potencia" class="form-label">Potencia (HP)</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <textarea class="form-control" id="descripcion" name="descripcion" rows="4" placeholder=""
                                    required style="min-height: 150px;">{{ $tractor->descripcion }}</textarea>
                                <label for="descripcion" class="form-label">Descripción</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="text" class="form-control rounded-2" id="imagen" name="imagen" value="{{ $tractor->imagen }}" required>
                                <label for="imagen" class="form-label">Imagen (ingrese la url de una imagen de un servicio
                                    del estilo Cloudinary)</label>
                            </div>

                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Actualizar Tractor</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
@extends('layouts.app')

@section('content')
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card shadow-sm bg-dark-subtle text-dark">
                    <div class="card-header text-center">
                        <h1 class="mb-0 text-center text-black fw-bolder fs-1">Añadir Tractor</h1>
                    </div>
                    <div class="card-body">
                        <form action="{{ route('tractores.store') }}" method="POST" enctype="multipart/form-data">
                            @csrf

                            <div class="mb-3 form-floating">
                                <input type="text" class="form-control rounded-2" id="nombre" name="nombre" placeholder=""
                                    required>
                                <label for="nombre" class="form-label">Nombre</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="text" class="form-control rounded-2" id="imagen" name="imagen" placeholder=""
                                    required>
                                <label for="imagen" class="form-label">Imagen (ingrese la url de una imagen de un servicio
                                    del estilo Cloudinary)</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="number" class="form-control rounded-2" id="anio_fabricacion"
                                    name="anio_fabricacion" placeholder="" required>
                                <label for="anio_fabricacion" class="form-label">Año de fabricación</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="number" class="form-control rounded-2" id="precio_mercado"
                                    name="precio_mercado" step="0.01" placeholder="" required>
                                <label for="precio_mercado" class="form-label">Precio de mercado</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <input type="number" class="form-control rounded-2" id="potencia" name="potencia"
                                    placeholder="" required>
                                <label for="potencia" class="form-label">Potencia (HP)</label>
                            </div>

                            <div class="mb-3 form-floating">
                                <textarea style="min-height: 150px; border: 1px solid #747b88;" class="form-control"
                                    id="descripcion" name="descripcion" rows="4" placeholder="" required></textarea>
                                <label for="descripcion" class="form-label">Descripción</label>
                            </div>

                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Añadir Tractor</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
@endsection
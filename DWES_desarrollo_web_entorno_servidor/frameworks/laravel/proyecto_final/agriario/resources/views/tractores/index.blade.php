@extends('layouts.app')

@section('content')
    <div class="container">
        <h1 class="mb-4 text-center text-white fw-bolder fs-1">Lista de Tractores</h1>

        <div class="mb-4 text-center">
            <a href="{{ route('tractores.create') }}" class="btn btn-success">Crear Nuevo Tractor</a>
        </div>

        @if($tractores->isEmpty())
            <p class="text-center text-gray-300">No hay tractores disponibles.</p>
        @else
            <div class="d-flex flex-column pb-4">
                <div class=" row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
                    @foreach($tractores as $tractor)
                        <div class="col">
                            <div class="card h-100 shadow-sm bg-gray-800 text-white border-gray-700">
                                <img src="{{ asset($tractor->imagen) }}" class="card-img-top"
                                    alt="Imagen de {{ $tractor->nombre }}">
                                <div class="card-body">
                                    <h5 class="card-title">{{ $tractor->nombre }}</h5>
                                    <p class="card-text"><strong>Año:</strong> {{ $tractor->anio_fabricacion }}</p>
                                    <p class="card-text"><strong>Precio:</strong> ${{ number_format($tractor->precio_mercado, 2) }}
                                    </p>
                                    <p class="card-text"><strong>Potencia:</strong> {{ $tractor->potencia }} HP</p>
                                    <p class="card-text">{{ Str::limit($tractor->descripcion, 100, '...') }}</p>
                                </div>
                                <div class="card-footer text-center bg-gray-700 border-top-gray-600">
                                    <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#tractorModal{{ $tractor->id }}">
                                        Ver más
                                    </button>

                                    <a href="{{ route('tractores.edit', $tractor->id) }}" class="btn btn-warning">Editar</a>

                                    <form action="{{ route('tractores.destroy', $tractor->id) }}" method="POST"
                                        style="display:inline;">
                                        @csrf
                                        @method('DELETE')
                                        <button type="submit" class="btn btn-danger">Eliminar</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="modal fade" id="tractorModal{{ $tractor->id }}" tabindex="-1"
                            aria-labelledby="tractorModalLabel{{ $tractor->id }}" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content bg-gray-800 text-white">
                                    <div class="modal-header bg-gray-700 border-bottom-gray-600">
                                        <h5 class="modal-title" id="tractorModalLabel{{ $tractor->id }}">{{ $tractor->nombre }}</h5>
                                        <button type="button" class="btn-close btn-close-white" data-bs-dismiss="modal"
                                            aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">
                                        <img src="{{ asset($tractor->imagen) }}" class="img-fluid mb-3"
                                            alt="Imagen de {{ $tractor->nombre }}">
                                        <p><strong>Año de fabricación:</strong> {{ $tractor->anio_fabricacion }}</p>
                                        <p><strong>Precio:</strong> ${{ number_format($tractor->precio_mercado, 2) }}</p>
                                        <p><strong>Potencia:</strong> {{ $tractor->potencia }} HP</p>
                                        <p><strong>Descripción:</strong> {{ $tractor->descripcion }}</p>
                                    </div>
                                    <div class="modal-footer bg-gray-700 border-top-gray-600">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    @endforeach
                </div>
                <div class="d-flex justify-content-center mt-4">
                    {{ $tractores->links() }}
                </div>
            </div>
        @endif
    </div>
@endsection
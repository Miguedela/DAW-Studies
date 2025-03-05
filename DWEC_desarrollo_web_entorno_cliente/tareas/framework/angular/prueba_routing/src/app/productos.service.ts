import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const URL_BASE = "https://ejerciciostutorialesya.com/vue/datos.php";

@Injectable({
  providedIn: 'root'
})

export class ProductosService {

  constructor(private httpclient: HttpClient) { }

  // Metodos para las distintas operaciones del producto

  // metodo para rescatar todos los productos
  obtenerProductos() {
    return this.httpclient.get<any>(`${URL_BASE}`);
  }

  // metodo para rescatar prodcuto por id
}

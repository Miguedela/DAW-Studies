
import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../productos.service';
import { Iproducto } from '../iproducto';

@Component({
  selector: 'app-listado-productos',
  standalone: false,
  templateUrl: './listado-productos.component.html',
  styleUrl: './listado-productos.component.css'
})
export class ListadoProductosComponent implements OnInit {

  productos!: Iproducto[];

  constructor(private servicioproductos: ProductosService) { }

  ngOnInit(): void {
    this.servicioproductos.obtenerProductos().subscribe(
      (data) => {
        this.productos = data;
        console.log(this.productos);

        console.log(this.productos[0].codigo);
        console.log(this.productos[0].descripcion);
        console.log(this.productos[0].precio);
      }
    );
  }

}

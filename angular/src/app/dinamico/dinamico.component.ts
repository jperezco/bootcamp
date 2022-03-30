import { Component, OnInit } from '@angular/core';
import { CalculadoraComponent } from '../calculadora/calculadora.component';
import { ContactosComponent } from '../contactos/componente.component';
import { DemosComponent } from '../demos/demos.component';
import { FormularioComponent } from '../formulario/formulario.component';
import { HomeComponent } from '../main/home/home.component';
import { PizzasComponent } from '../pizzas/componente.component';

@Component({
  selector: 'app-dinamico',
  templateUrl: './dinamico.component.html',
  styleUrls: ['./dinamico.component.css']
})
export class DinamicoComponent implements OnInit {
  menu = [
    { texto: 'pizzas', icono: 'fa-solid fa-calculator', componente: PizzasComponent},
    { texto: 'contactos', icono: 'fa-solid fa-calculator', componente: ContactosComponent},
    { texto: 'formulario', icono: 'fa-solid fa-calculator', componente: FormularioComponent},
    { texto: 'calculadora', icono: 'fa-solid fa-calculator', componente: CalculadoraComponent},
    { texto: 'inicio', icono: 'fa-solid fa-house', componente: HomeComponent},
    { texto: 'demos', icono: 'fa-solid fa-chalkboard-user', componente: DemosComponent},
  ]
  actual = this.menu[0].componente

  constructor() { }

  ngOnInit(): void {
  }

  seleccionar(indice: number): void {
    this.actual  = this.menu[indice].componente
  }
}

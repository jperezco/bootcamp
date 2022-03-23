import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculadora',
  templateUrl: './calculadora.component.html',
  styleUrls: ['./calculadora.component.css']
})
export class CalculadoraComponent implements OnInit {

  public valorActual: string;
  public valorAnterior: string;
  public operacionesSoportadas: string;
  public operadorPendiente: string;
  public acumulado: number;


  constructor() {
    this.valorActual = '0';
    this.valorAnterior = '';
    this.operacionesSoportadas = '+-*/=';
    this.operadorPendiente = '+';
    this.acumulado = 0;
  }

  get Acumulado(): number {return this.acumulado};

  public calcula(operando2: string, nuevoOperador: string): string {
    let operando2Float = parseFloat(operando2);
    switch(this.operadorPendiente) {
      case '+':
        this.acumulado += operando2Float;
        break;
      case '-':
        this.acumulado -= operando2Float;
        break;
      case '*':
        this.acumulado *= operando2Float;
        break;
      case '/':
        this.acumulado /= operando2Float;
        break;
      case '=':
        break;
    }
    this.operadorPendiente = nuevoOperador;
    return String(this.Acumulado);
  }

  public mostrarValorActual(value: string): void {
    if(this.valorActual === '0'){
      this.valorActual = value;
    } else {
      this.valorActual += value;
    }
  }

  public mostrarValorAnterior(value: string): void {
    this.valorAnterior = this.calcula(this.valorActual, value) + value;
    this.valorActual = '0';
  }

  public mostrarIgual(): void {
    this.valorAnterior = this.calcula(this.valorActual, '=');
    this.valorActual = '0';
  }

  public mostrarDecimal(): void {
    for(let i = 0; i <  this.valorActual.length ; i++){
      if(this.valorActual.charAt(i) === '.'){
        return;
      }
    }
    this.valorActual += '.'
  }

  public borrarTodo() : void {
    this.valorActual = '0';
    this.valorAnterior = '';
    this.acumulado = 0;
  }

  public borrarUno() : void {
    if(this.valorActual.length === 1) {
      this.valorActual = '0';
    } else {
      this.valorActual = this.valorActual.slice(0, this.valorActual.length - 1);
    }
  }

  ngOnInit(): void {
  }

}

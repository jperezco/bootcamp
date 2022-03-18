class Calculadora {
  constructor(valorActual, valorAnterior) {
    this.operacionesSoportadas = "+-*/=";
    this.valorActual = valorActual;
    this.valorAnterior = valorAnterior;
    this.inicializa();
  }

  inicializa() {
    this.acumulado = 0;
    this.operadorPendiente = "+";
  }

  get ACUMULADO() {
    return this.acumulado;
  }

  isOperacion(operacion) {
    return this.operacionesSoportadas.indexOf(operacion) != -1;
  }

  calcula(operando2, nuevoOperador) {
    if (!this.isOperacion(nuevoOperador)) {
      throw new Error("Operación no soportada");
    }
    operando2 = parseFloat(operando2);
    switch (this.operadorPendiente) {
      case "+":
        this.acumulado += operando2;
        break;
      case "-":
        this.acumulado -= operando2;
        break;
      case "*":
        this.acumulado *= operando2;
        break;
      case "/":
        this.acumulado /= operando2;
        break;
      case "=":
        break;
    }
    this.operadorPendiente = nuevoOperador;
    return this.ACUMULADO;
  }

  imprimirValorActual(valor) {
    if (this.valorActual.textContent == 0) {
      this.valorActual.textContent = valor;
    } else {
      this.valorActual.textContent += valor;
    }
  }

  imprimirValorAnterior(operador) {
    this.valorAnterior.textContent = this.calcula(
      this.valorActual.textContent,
      operador
    );
    this.valorAnterior.textContent += operador;
  }

  borrarTodo() {
    this.valorActual.textContent = "0";
    this.valorAnterior.textContent = "";
    this.inicializa();
  }

  borrarUno() {
    if (this.valorActual.textContent.length == 1) {
      this.valorActual.textContent = "0";
    } else {
      this.valorActual.textContent = this.valorActual.textContent.slice(
        0,
        this.valorActual.textContent.length - 1
      );
    }
  }

  borrarPantallaActual() {
    this.valorActual.textContent = "0";
  }

  copiarValor() {
    this.valorAnterior.textContent = this.valorActual.textContent;
  }
}

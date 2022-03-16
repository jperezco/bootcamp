function Ejercicio0() {
  //Pide el dato y lo mete en cad.
  let cad = prompt("Dame el nombre");
  //Saca en pantalla
  alert(`La cadena es ${cad}`);
}

function dameValores() {
  //La ejecución se para aquí sí o sí.
  debugger;
  return [1, 2, 3];
}

function Ejercicio1(min, max) {
  return parseInt(Math.random() * (max + 1 - min) + min);
}

function Ejercicio2() {
  let numeroBuscado = parseInt(Math.random() * 101);
  let intentos = 0;
  let encontrado = false;

  do {
    intentos += 1;
    let numeroIntroducido = parseInt(prompt("Introduce el número"));
    if (numeroIntroducido === numeroBuscado) {
      encontrado = true;
    } else if (numeroBuscado > numeroIntroducido) {
      alert(`El número que buscas es mayor al que has introducido`);
    } else {
      alert(`El número que buscas es menor al que has introducido`);
    }
  } while (intentos < 10 && !encontrado);

  if (encontrado) {
    return alert(`Has acertado!!!`);
  } else {
    return alert(
      `Se acabaron los intentos. :( El número buscado era el ${numeroBuscado}`
    );
  }
}

function Ejercicio3(numeroElementos) {
  let conjunto = [];
  do {
    let valor = prompt("Dame el valor que quieres que introduzca");
    conjunto.push(valor);
  } while (conjunto.length < numeroElementos);
  return conjunto;
}

function Ejercicio4Primo(numero) {
  for (var i = 2; i < numero; i++) {
    if (numero % i === 0) {
      return false;
    }
  }
  return numero !== 1;
}

function Ejercicio4(cantidadNumerosPrimos) {
  let numerosPrimos = [];
  let i = 2;
  do {
    if (Ejercicio4Primo(i)) {
      numerosPrimos.push(i);
    }
    i++;
  } while (numerosPrimos.length < cantidadNumerosPrimos);
  return numerosPrimos;
}

function Ejercicio5(nif) {
  if (nif == null) return true;
  nif = nif.toUpperCase();
  if (!/^\d{1,8}[A-Za-z]$/.test(nif)) return false;
  return (
    "TRWAGMYFPDXBNJZSQVHLCKE".charAt(
      parseInt(nif.substring(0, nif.length - 1)) % 23
    ) == nif.charAt(nif.length - 1)
  );
}

function Ejercicio6(cadena) {
  let cadenaSinEspacios = cadena.replace(/ /g, "").toLowerCase();
  let cadenaInvertida = cadenaSinEspacios.split("").reverse().join("");
  if (cadenaSinEspacios == cadenaInvertida) {
    return true;
  }
  return false;
}

// Objetos.

function JuegoDelNumero() {
  this.inicializar = function () {
    this.numeroBuscado = parseInt(Math.random() * 101);
    this.intentos = 0;
    this.encontrado = false;
    this.resultado = "Pendiente de empezar";
  };

  this.inicializar();

  this.jugada = function (numeroIntroducido) {
    if (this.getFinalizado()) {
      return "El juego ha finalizado";
    }
    this.intentos++;
    if (this.numeroBuscado === numeroIntroducido) {
      this.encontrado = true;
      this.resultado = "Acertaste";
    } else if (this.intentos >= 10) {
      this.resultado = `Se acabaron los intentos, el numero buscado era el ${this.numeroBuscado}`;
    } else if (this.numeroBuscado > numeroIntroducido) {
      this.resultado = "El número que buscas es mayor";
    } else {
      this.resultado = "El número que buscas es menor";
    }
  };

  this.getResultado = function () {
    return this.resultado;
  };

  this.getFinalizado = function () {
    return this.intentos >= 10 || this.encontrado;
  };

  this.getJugada = function () {
    return this.intentos;
  };
}

class JuegoConClase {
  constructor(maxIntentos, valores) {
    // El subrayado es para indicar que no queremos que la variable se use desde
    // fuera. Es un convenio. Si la usas, queda bajo tu responsabilidad.
    this._maxIntentos = maxIntentos;
    this._valores = valores;
    this.Inicializa();
  }

  Inicializa() {
    this._numeroBuscado = aleatorio(1, this._valores);
    this.intentos = 0;
    this.encontrado = false;
    this.mensaje = "Listo para jugar";
  }

  PruebaCon(numeroIntroducido) {
    if (this.intentos >= this._maxIntentos)
      throw new Error("Excedido el numero de intentos");
    if (!Number.isInteger(+numeroIntroducido))
      throw new Error("No es un numero correcto");
    this.intentos += 1;
    if (this._numeroBuscado == numeroIntroducido) {
      this.encontrado = true;
      this.mensaje = "Bieeen!!! Acertaste.";
      return this.mensaje;
    }
    if (this.intentos >= this._maxIntentos) {
      this.mensaje =
        "Upsss! Se acabaron los intentos, el número era el " +
        this._numeroBuscado;
      return this.mensaje;
    }
    if (this._numeroBuscado > numeroIntroducido) {
      this.mensaje = "Mi número es mayor.";
      return this.mensaje;
    }
    this.mensaje = "Mi número es menor.";
    return this.mensaje;
  }

  DameMaxIntentos() {
    return this._maxIntentos;
  }

  get maxIntentos() {
    return this._maxIntentos;
  }

  get intento() {
    return this.intentos + 1;
  }
}

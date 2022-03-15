function Ejercicio0(){
    //Pide el dato y lo mete en cad.
    let cad = prompt("Dame el nombre")
    //Saca en pantalla
    alert(`La cadena es ${cad}`)
}

function dameValores() {
    //La ejecución se para aquí sí o sí.
    debugger;
    return [1,2,3];
}

function Ejercicio1(min, max){
    return parseInt(Math.random() * (max + 1 - min) + min);
}

function Ejercicio2(){

    let numeroBuscado = parseInt(Math.random() * 101);
    let intentos = 0;
    let encontrado = false;

    do {
        intentos += 1;
        let numeroIntroducido = parseInt(prompt("Introduce el número"));
        if(numeroIntroducido === numeroBuscado){
            encontrado = true;
        } else if (numeroBuscado > numeroIntroducido){
            alert(`El número que buscas es mayor al que has introducido`);
        } else {
            alert(`El número que buscas es menor al que has introducido`);
        }
    } while (intentos < 10 && !encontrado);

    if (encontrado){
        return alert(`Has acertado!!!`);
    } else {
        return alert(`Se acabaron los intentos. :( El número buscado era el ${numeroBuscado}`);
    }
}

function Ejercicio3(numeroElementos){
    let conjunto = [];
    do {
        let valor = prompt("Dame el valor que quieres que introduzca");
        conjunto.push(valor);
    } while (conjunto.length < numeroElementos);
    return conjunto;
}
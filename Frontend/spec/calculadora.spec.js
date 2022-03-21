describe("Pruebas de la calculadora", () => {

  describe("Inicializa", () => {
    it("OK", () => {
      let pantallaPrincipal = { textContent: 10 };
      let pantallaSecundaria = { textContent: 20 };
      let calculadora = new Calculadora(pantallaPrincipal, pantallaSecundaria);
      expect(calculadora.ACUMULADO).toBe(0);
      expect(calculadora.operadorPendiente).toBe("+");
      expect(calculadora.operacionesSoportadas).toBe("+-*/=");
    });
  });

  describe("Operación soportada", () => {
    let pantallaPrincipal = { textContent: 10 };
    let pantallaSecundaria = { textContent: 20 };
    let calculadora = new Calculadora(pantallaPrincipal, pantallaSecundaria);

    describe("Operación soportada OK", () => {
      ["+", "-", "*", "/", "="].forEach((caso) => {
        it(`Operador: ${caso}`, () =>
          expect(calculadora.isOperacion(caso)).toBeTrue());
      });
    });

    describe("Operación soportada KO", () => {
      ["2", "?", "(", "++", "%"].forEach((caso) => {
        it(`Operador: ${caso}`, () =>
          expect(calculadora.isOperacion(caso)).toBeFalse());
      });
    });
  });

  describe('Calcula', () => {
    let pantallaPrincipal = { textContent: 10 };
    let pantallaSecundaria = { textContent: 20 };
    let calculadora = new Calculadora(pantallaPrincipal, pantallaSecundaria);
    it('Calcula OK', () => {
        expect(calculadora.calcula(2, '+')).toBe(2);
        expect(calculadora.calcula(6, '-')).toBe(8);
        expect(calculadora.calcula(15, '*')).toBe(-7);
        expect(calculadora.calcula(2, '/')).toBe(-14);
        expect(calculadora.calcula(2, '-')).toBe(-7);
        expect(calculadora.calcula(-3.5, '=')).toBe(-3.5);
    })
    it('Calcula KO', () => {
        expect(() => calculadora.calcula(2, '%')).toThrow();
    })
  });
});

describe("Pruebas de los ejercicios", () => {

  describe("Ejercicio 1", () => {

    describe("OK", () => {

      it("Genera aleatorio", () => {
        let spy = spyOn(Math, 'random').and.returnValue(0.5);
        let num = aleatorio(1, 100);
        expect(spy).toHaveBeenCalled();
        expect(num).toBeGreaterThanOrEqual(1);
        expect(num).toBeLessThanOrEqual(100);
        expect(num).toBe(51);
      });

    });

    describe("KO", () => {
        it('Falta parámetro', () => {
            expect(() => aleatorio(1)).toThrow();
        })
    });
  });

  describe("Ejercicio 2", () => {
      it('Pendiente')
  });

  describe('Ejercicio 5', () => {
      describe('NIF OK', () => {
          ['12345678z', '1234S', '4g'].forEach(caso => {
              it(`NIF : ${caso}`, () => expect(Ejercicio5(caso)).toBeTrue())
          })
      })
  });

});

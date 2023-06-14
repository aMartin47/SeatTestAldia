//Funciones de prueba



//Describe o Context
describe ('Testing dummy para probar en el configurador de Seat', () => {
    beforeEach(() => {
        // Accedemos a la URL del configurador de Seat
        cy.visit('https://configurador.seat.es/')
        //aceptamos cookies
        cy.get("#onetrust-accept-btn-handler").contains("Aceptar Todas las Cookies").click();
        
        // Añadimos excepcion para evitar test fallidos por errores en la carga de la pagina
        Cypress.on('uncaught:exception', (err, runnable) => {
            // returning false here prevents Cypress from
            // failing the test
            return false
          })
    })
    context ('Acceder al presupuesto final del Seat Ibiza', () => {
        it('seleccionamos el Seat Ibiza y realizamos la configuracion del vehiculo', () => {
            //seleccionamos ibiza
            cy.get(".ng-star-inserted").contains("IBIZA").click();
            //btn configuralo
            cy.get(".start-config-button-container").eq(1).click("bottom");
            //seleccionamos version de ibiza
            cy.get(".engine-name").contains("Ibiza 1.5").click();
            //btn siguiente
            cy.get("seat-button").eq(1).click();
            //seleccionamos color negro
            cy.get("seat-circle").eq(4).click();
            //seleccionamos llantas de 18
            cy.get("seat-selectable-container").eq(1).click();
            //btn siguiente
            cy.get("seat-button").eq(1).click();
            //seleccionamos tapiceria 2
            cy.get("seat-circle").eq(1).click();
            //btn siguiente
            cy.get("seat-button").eq(1).click();
            //btn siguiente sin añadir packs
            cy.get("seat-button").eq(16).click();
            
            //comprobamos que aparece la opción de descargar configuracion
            cy.get(".ng-star-inserted").contains("descarga tu configuración aquí");
        })
        
    })
})
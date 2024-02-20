@PRUEBA2
Feature: Carga de nuevo envío individual

  Scenario: Carga de nuevo envío individual
    Given el usuario consumidor final está logueado y en la page home
    When ingresa en nuevo envío individual
    And llena los campos de origen destino y paquete
    And presiona en agregar envío
    And el envío se muestra en la grilla de envíos pendientes
    And presiona en cotizar
    And se muestra la grilla de checkout
    
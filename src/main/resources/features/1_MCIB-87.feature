Feature: Nuevo envío individual cdor final a dom clasico y pago con tarjeta

	@TEST_MCIB-87
	Scenario: Nuevo envío individual cdor final a dom clasico y pago con tarjeta
		Given el usuario está logueado y en la page home
		When ingresa en nuevo envío individual
		And llena los campos de origen destino y paquete
		And presiona en agregar envío
		And el envío se muestra en la grilla de envíos pendientes
		And presiona en cotizar
		And se muestra la grilla de checkout
		Then realiza el pago del envío
		And se confirma que el pago se ha realizado con éxito
		

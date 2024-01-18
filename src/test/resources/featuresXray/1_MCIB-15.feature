Feature: Validar que el inicio de sesión para usuarios registrados se realice con éxito al ingresar credenciales válidas.

	Background:
		#@PRECOND_MCIB-12
		Given un usuario registrado
		And estoy en la página de inicio de sesión

	@TEST_MCIB-15
	Scenario: Validar que el inicio de sesión para usuarios registrados se realice con éxito al ingresar credenciales válidas.
		Scenario: Login Exitoso
				When ingreso credenciales válidas
				Then debería iniciar sesión con éxito
		

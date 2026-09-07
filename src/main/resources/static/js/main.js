document.addEventListener('DOMContentLoaded', function () {

    // 1. Lógica para el Login
    const formLogin = document.getElementById('formLogin');
    if (formLogin) {
        formLogin.addEventListener('submit', function (event) {
            event.preventDefault();

            const correo = document.getElementById('correo')?.value || '';
            const password = document.getElementById('password')?.value || '';

            if (correo.trim() === '' || password.trim() === '') {
                alert('Por favor complete el correo y la contraseña.');
            } else {
                alert('Inicio de sesión correcto.');
                window.location.href = '/dashboard';
            }
        });
    }

    // 2. Lógica para Formularios de Registro / Usuario
    const formCliente = document.getElementById('formCliente');
    if (formCliente) {
        formCliente.addEventListener('submit', function (event) {
            event.preventDefault();

            const nombre = document.getElementById('nombre')?.value || '';
            const documento = document.getElementById('documento')?.value || '';
            const correo = document.getElementById('correo')?.value || '';

            if (nombre === '' || documento === '' || correo === '') {
                alert('Por favor complete los campos obligatorios.');
            } else {
                alert('Datos procesados correctamente.');
            }
        });
    }

    // 3. Filtro de búsqueda en tablas (si existe)
    const buscarCliente = document.getElementById('buscarCliente');
    if (buscarCliente) {
        buscarCliente.addEventListener('keyup', function () {
            const textoBusqueda = buscarCliente.value.toLowerCase();
            const filas = document.querySelectorAll('#tablaClientes tbody tr');

            filas.forEach(function (fila) {
                const contenidoFila = fila.textContent.toLowerCase();
                fila.style.display = contenidoFila.includes(textoBusqueda) ? '' : 'none';
            });
        });
    }
});

// Función global para alternar la visibilidad de la contraseña
function alternarContrasena() {
    const input = document.getElementById('contrasena');
    if (input) {
        if (input.type === 'password') {
            input.type = 'text';
        } else {
            input.type = 'password';
        }
    }
}
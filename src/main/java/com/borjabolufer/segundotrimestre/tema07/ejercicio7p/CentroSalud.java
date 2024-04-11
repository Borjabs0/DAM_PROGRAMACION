package com.borjabolufer.segundotrimestre.tema07.ejercicio7p;

import com.borjabolufer.segundotrimestre.tema07.ejercicio07.Config;
import com.borjabolufer.utils.Lib;
import net.datafaker.Faker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CentroSalud {
    private final Paciente[] pacientes;
    private int nPacientes;
    private final AtencionMedica[] historial;
    private int nRegistros;
    private int lastSIP = 10103001;
    private static final String[] arraySintomatologia = {"Dolor abdominal", "Mareo generalizado", "Dolor fuerte en el pecho", "Dolor en el brazo", "Dolor en la pierna", "Gripe", "Resfriado común", "Escalofríos", "Migraña intensa", "Fuerte contusión"};

    public CentroSalud(int maxPacientes, int maxHistorial) {
        this.pacientes = new Paciente[maxPacientes];
        this.historial = new AtencionMedica[maxHistorial];
        this.nPacientes = 0;
        this.nRegistros = 0;
        if (Config.DEBUG)
            generarDatosAleatorios(80, 100);
    }

    /**
     * Genera datos para realizar pruebas
     * @param nPacientes Cantidad de pacientes a generar
     * @param nRegistrosHistorial Cantidad de registros de atenciones
     */
    private void generarDatosAleatorios(int nPacientes, int nRegistrosHistorial) {
        generarPacientesAleatorios(nPacientes);
        generarRegistrosHistorialAleatorios(nRegistrosHistorial);
        ordenarHistorial();
    }

    /**
     * Genera la cantidad indicada de pacientes aleatorios
     * @param nPacientes Cantidad de pacientes a generar
     */
    private void generarPacientesAleatorios(int nPacientes) {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 0; i < nPacientes; i++) {
            int sip = ++lastSIP;
            String nombre = faker.name().firstName();
            String apellido1 = faker.name().lastName();
            String apellido2 = faker.name().lastName();
            Paciente.Sexo sexo = Lib.random(0, 1) == 0 ? Paciente.Sexo.M : Paciente.Sexo.V;
            int edad = Lib.random(1, 90);
            pacientes[i] = new Paciente(sip, nombre, apellido1, apellido2, sexo, edad);
            this.nPacientes++;
        }
    }

    /**
     * Genera registros de atenciones médicas aleatorias
     * @param nRegistrosHistorial Cantidad de registros a generar
     */
    private void generarRegistrosHistorialAleatorios(int nRegistrosHistorial) {
        int restantes = nRegistrosHistorial;
        int anyoActual = new GregorianCalendar().get(Calendar.YEAR);
        // OJO Enero es 0 en las clases Calendar
        int mesActual = new GregorianCalendar().get(Calendar.MONTH);
        int diaActual = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
        while (restantes > 0) {
            int i = 0;
            while (i < nPacientes && restantes > 0) {
                int dia = Lib.random(1, diaActual);
                int hora = Lib.random(0,23);
                int minutos = Lib.random(0,59);
                GregorianCalendar fechaEntrada = new GregorianCalendar(anyoActual, mesActual, dia, hora, minutos);
                String sintomatologia = arraySintomatologia[Lib.random(0,arraySintomatologia.length-1)];
                float temperatura = Lib.random(36.5f, 41);
                float ppm = Lib.random(50, 120);
                float tenSis = Lib.random(105, 180);
                float tenDias = Lib.random(45, 105);
                // Si el paciente no ha entrado hoy suponemos que se le ha dado el alta
                if (dia != diaActual) {
                    GregorianCalendar fechaAlta = new GregorianCalendar();
                    fechaAlta.setTime(fechaEntrada.getTime());
                    fechaAlta.add(Calendar.HOUR_OF_DAY, Lib.random(1,12));
                    fechaAlta.add(Calendar.MINUTE, Lib.random(2,59));
                    int mAlta = Lib.random(1,100);
                    AtencionMedica.MotivoAlta motivoAlta;
                    if (mAlta <= 75) { // El 75% mejoran
                        motivoAlta = AtencionMedica.MotivoAlta.MEJORA;
                    } else if (mAlta <= 99) { // El 24% (99 - 75) se les deriva al hospital
                        motivoAlta = AtencionMedica.MotivoAlta.DERIVACION_HOSPITAL;
                    } else { // El 1% restante muere
                        motivoAlta = AtencionMedica.MotivoAlta.DEFUNCION;
                    }
                    historial[nRegistros] = new AtencionMedica(pacientes[i], sintomatologia, fechaEntrada, temperatura, ppm, tenSis, tenDias, fechaAlta, motivoAlta);
                } else { // El paciente continua en el centro de salud
                    historial[nRegistros] = new AtencionMedica(pacientes[i], sintomatologia);
                    boolean atendido = Lib.random(0, 1) != 0;
                    if (atendido) {
                        historial[nRegistros].atender(temperatura, ppm, tenSis, tenDias);
                    }
                }
                i++;
                nRegistros++;
                restantes--;
            }
        }
    }


    /**
     * Busca las atenciones realizadas al paciente con el sip indicado
     * @param sip SIP del paciente
     * @return Array con las atenciones del paciente o null
     */
    public AtencionMedica[] buscarHistoricoPorSip(int sip) {
        int registrosPaciente = 0;
        AtencionMedica[] historicoPaciente = null;
        for (int i = 0; i < nRegistros; i++) {
            if (historial[i].getPaciente().getSip() == sip) {
                registrosPaciente++;
            }
        }
        if (registrosPaciente > 0) {
            historicoPaciente = new AtencionMedica[registrosPaciente];
            int cont = 0;
            /* Una vez sabemos el número de registros del paciente los asignamos al vector **/
            for (int i = 0; i < nRegistros; i++) {
                if (historial[i].getPaciente().getSip() == sip) {
                    historicoPaciente[cont] = historial[i];
                    cont++;
                }
            }
        }
        return historicoPaciente;
    }

    /**
     * Busca el paciente con el sip indicado
     * @param sip SIP del paciente a buscar
     * @return Posición del paciente si lo encuentra ó -1
     */
    public int buscarPacientePorSip(int sip) {
        for (int i = 0; i < nPacientes; i++) {
            if (pacientes[i].getSip() == sip) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Busca las atenciones médicas realizadas entre la fecha de inicio y fecha fin indicadas
     * @param fechaInicio
     * @param fechaFin
     * @return Array de atenciones existentes entre las fechas indicadas o null
     */
    public AtencionMedica[] buscarHistoricoPorFechas(GregorianCalendar fechaInicio, GregorianCalendar fechaFin) {
        int registrosFechas = 0;
        AtencionMedica[] historicoFechas = null;
        if (fechaFin == null) {
            fechaFin = new GregorianCalendar();
        }
        for (int i = 0; i < nRegistros; i++) {
            if (historial[i].getFechaEntrada().getTimeInMillis() >= fechaInicio.getTimeInMillis() &&
                    historial[i].getFechaEntrada().getTimeInMillis() <= fechaFin.getTimeInMillis()) {
                registrosFechas++;
            }
        }
        if (registrosFechas > 0) {
            historicoFechas = new AtencionMedica[registrosFechas];
            int cont = 0;
            /* Una vez sabemos el número de registros del paciente los asignamos al vector **/
            for (int i = 0; i < nRegistros; i++) {
                if (historial[i].getFechaEntrada().getTimeInMillis() >= fechaInicio.getTimeInMillis() &&
                        historial[i].getFechaEntrada().getTimeInMillis() <= fechaFin.getTimeInMillis()) {
                    historicoFechas[cont] = historial[i];
                    cont++;
                }
            }
        }
        return historicoFechas;
    }

    /**
     * Ordena el historial de atenciones médicas por fecha
     */
    private void ordenarHistorial() {
        boolean hayCambios = true;
        while (hayCambios) {
            hayCambios = false;
            for (int i = 0; i < nRegistros - 1; i++) {
                // Si el elemento actual es mayor que el elemento siguiente los intercambiamos
                if (historial[i].getFechaEntrada().getTimeInMillis() > historial[i+1].getFechaEntrada().getTimeInMillis()) {
                    intercambio(historial, i, i + 1);
                    hayCambios = true;
                }
            }
        }
    }

    /**
     * Intercambia dos posiciones del array
     * @param array Array de Atenciones médicas
     * @param i
     * @param j
     */
    private void intercambio(AtencionMedica[] array, int i, int j) {
        AtencionMedica aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    /**
     * Crea un paciente con los datos indicados
     * @param sip SIP del paciente
     * @param nombre Nombre del paciente
     * @param apellido1 Primer apellido
     * @param apellido2 Segundo apellido
     * @param sexo M (Mujer) ó V (Varón)
     * @param edad Años del paciente
     * @return La posición donde se ha insertado el paciente creado
     */
    public int nuevoPaciente(int sip, String nombre, String apellido1, String apellido2, Paciente.Sexo sexo, int edad) {
        this.pacientes[nPacientes] = new Paciente(sip, nombre, apellido1, apellido2, sexo, edad);
        // Utilizamos post incremento para que el return devuelva la posición donde lo ha insertado
        return nPacientes++;
    }

    /**
     * Añade un nuevo registro de Atención médica con los datos indicados
     * @param paciente Paciente a registrar
     * @param sintomatologia Síntomas del paciente
     * @return La posición donde se ha insertado la atención médica creada.
     */
    public int registrarPaciente(Paciente paciente, String sintomatologia) {
        historial[nRegistros] = new AtencionMedica(paciente, sintomatologia);
        // Utilizamos post incremento para que el return devuelva la posición donde lo ha insertado
        return nRegistros++;
    }

    /**
     * Obtiene el registro de atención médica actual de un paciente
     * El paciente aún permanece en el Centro de Salud ya que no se le ha dado el alta
     * @param sip SIP del paciente
     * @return AtencionMedica
     */
    public AtencionMedica obtenerRegistroAtencionPaciente(int sip) {
        for (int i = 0; i < nRegistros; i++) {
            Paciente paciente = historial[i].getPaciente();
            if (paciente.getSip() == sip && historial[i].getFechaAlta() == null) {
                return historial[i];
            }
        }
        return null;
    }

    /**
     * Atiende al paciente indicado registrando sus constantes vitales
     * @param sip SIP del paciente
     * @param temperatura Temperatura en grados centígrados
     * @param ppm Pulsaciones por minuto
     * @param tenSis Tensión sistólica
     * @param tenDias Tensión diastólica
     * @return true si el paciente ha podido ser atendido o false en caso contrario
     */
    public boolean atenderPaciente(int sip, float temperatura, float ppm, float tenSis, float tenDias) {
        AtencionMedica atencionMedica = obtenerRegistroAtencionPaciente(sip);
        if (atencionMedica != null) {
            return atencionMedica.atender(temperatura, ppm, tenSis, tenDias);
        }
        return false;
    }

    /**
     * Obtiene la media de todas las temperaturas existentes en el historial
     * @return float con la media total
     */
    public float mediaTemperatura() {
        float sumaTemperaturas = 0;
        for (int i = 0; i < nRegistros; i++) {
            sumaTemperaturas += historial[i].getTemperatura();
        }
        return sumaTemperaturas / nRegistros;
    }

    /**
     * Obtiene la media de pulsaciones por minuto existentes en el historial
     * @return float con la media
     */
    public float mediaPpm() {
        float sumaPpm = 0;
        for (int i = 0; i < nRegistros; i++) {
            sumaPpm += historial[i].getPpm();
        }
        return sumaPpm / nRegistros;
    }

    /**
     * Obtiene la media de tensiones sistólicas existentes en el historial
     * @return float con la media
     */
    public float mediaTenSis() {
        float sumaTenSis = 0;
        for (int i = 0; i < nRegistros; i++) {
            sumaTenSis += historial[i].getTensionSistolica();
        }
        return sumaTenSis / nRegistros;
    }

    /**
     * Obtiene la media de tensiones diastólicas existentes en el historial
     * @return float con la media
     */
    public float mediaTenDias() {
        float sumaTenDias = 0;
        for (int i = 0; i < nRegistros; i++) {
            sumaTenDias += historial[i].getTensionDiastolica();
        }
        return sumaTenDias / nRegistros;
    }

    /**
     * Obtiene la media de las constantes vitales existentes en el historial
     * @return Array con las medias de las constantes vitales
     */
    public float[] mediaPreRev() {
        float[] mediasPreRev = new float[4];
        for (int i = 0; i < nRegistros; i++) {
            for (int j = 0; j < mediasPreRev.length; j++) {
                mediasPreRev[j] += historial[i].getPreRev()[j];
            }

        }
        for (int j = 0; j < mediasPreRev.length; j++) {
            mediasPreRev[j] /= nRegistros;
        }
        return mediasPreRev;
    }

    /**
     * Obtiene la edad media de los pacientes que han sido o están siendo atendidos en el último mes
     * @return float con la media
     */
    public float mediaEdadPacientes() {
        float sumaEdad = 0;
        for (int i = 0; i < nPacientes; i++) {
            sumaEdad += pacientes[i].getEdad();
        }
        return sumaEdad / nPacientes;
    }

    /**
     * Obtiene el porcentaje de mujeres que han sido o están siendo atendidas en el último mes
     * @return float con el porcentaje de mujeres
     */
    public float porcentajeMujeres() {
        float cantidadMujeres = 0;
        for (int i = 0; i < nPacientes; i++) {
            if (pacientes[i].getSexo() == Paciente.Sexo.M) {
                cantidadMujeres++;
            }
        }
        return (cantidadMujeres / nPacientes) * 100;
    }

    /**
     * Obtiene el porcentaje de hombres que han sido o están siendo atendidos en el último mes
     * @return float con el porcentaje de hombres
     */
    public float porcentajeHombres() {
        float cantidadHombres = 0;
        for (int i = 0; i < nPacientes; i++) {
            if (pacientes[i].getSexo() == Paciente.Sexo.V) {
                cantidadHombres++;
            }
        }
        return (cantidadHombres / nPacientes) * 100;
    }

    public Paciente[] getPacientes() {
        return this.pacientes;
    }

    public AtencionMedica[] getHistorial() {
        return this.historial;
    }
}
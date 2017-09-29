/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 */
package UTIL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log implements Serializable {

    private static final Log INSTANCE = new Log();

    private boolean logTXT = false;
    private int nivel = 0;

    private String ruta = "/home/tomcat/logs/";
    private String usuario = "NN";

    private Log() {
    }

    public static Log getInstance() {
        return INSTANCE;
    }

    private void msgLog(String severidad, String mensaje) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String tab = "";

        for (int i = 1; i <= this.nivel; i++) {
            tab += "    ";
        }

        String linea = df.format(date) + " " + tab + severidad + mensaje;
        if (this.logTXT) {
            df = new SimpleDateFormat("yyyy-MM-dd");
            Date dateCarpeta = new Date();
            String carpeta = this.ruta.concat(df.format(dateCarpeta) + "/");

            if (!(new File(carpeta).exists())) {
                (new File(carpeta)).mkdirs();
            }

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(carpeta + this.usuario + ".log", true));

                writer.write(linea + "\n");
                writer.close();
            } catch (IOException e) {
                System.out.println(df.format(date) + " " + tab + "Navegadorcito - ERROR: [" + this.usuario + "] " + e.getMessage());
            }
        }
    }

    public void msgInicial(String mensaje) {
        this.nivel = 0;

        this.msgLog("INI ", mensaje);
        this.nivel = 1;
    }

    public void msgInfo(String mensaje) {
        if (this.nivel <= 0) {
            this.nivel = 1;
        }

        this.msgLog("INFO: ", mensaje);
    }

    public void msgError(String mensaje) {
        if (this.nivel <= 0) {
            this.nivel = 1;
        }

        this.msgLog("ERROR: ", mensaje);
    }

    public void msgAdver(String mensaje) {
        if (this.nivel <= 0) {
            this.nivel = 1;
        }

        this.msgLog("ADVER: ", mensaje);
    }

    public void aumenatarNivel() {
        this.nivel++;
    }

    public void disminuirNivel() {
        this.nivel--;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}

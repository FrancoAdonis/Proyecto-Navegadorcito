package UTIL;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class FuncionNumero implements Serializable {

    private static Logger logger = Logger.getLogger("[FuncionNumero]");

    public static BigDecimal nvlBigDecimal(String texto) {
        BigDecimal numero = new BigDecimal(0);
        if (texto == null || "".equals(texto.trim()) || "null".equals(texto.trim().toLowerCase()) || "0".equals(texto.trim())) {
            return numero;
        }
        try {
            numero = new BigDecimal(texto);
        } catch (Exception e) {
            System.out.println("[Error][FuncionNumero][nvlBigDecimal][Exception]: " + e.getMessage());
            logger.log(Level.SEVERE, "[Error][FuncionNumero][nvlBigDecimal][Exception]: {0}", e.getMessage());
            return new BigDecimal(0);
        }
        return numero;
    }

    public static int nvlInteger(String texto) {
        int numero = 0;
        if (texto == null || "".equals(texto.trim()) || "null".equals(texto.trim().toLowerCase()) || "0".equals(texto.trim())) {
            return numero;
        }
        try {
            numero = Integer.parseInt(texto);
        } catch (Exception e) {
            System.out.println("[Error][FuncionNumero][nvlInteger][Exception]: " + e.getMessage());
            logger.log(Level.SEVERE, "[Error][FuncionNumero][nvlInteger][Exception]: {0}", e.getMessage());
            return 0;
        }
        return numero;
    }

    public static Short nvlShort(String texto) {
        Short numero = 0;
        if (texto == null || "".equals(texto.trim()) || "null".equals(texto.trim().toLowerCase()) || "0".equals(texto.trim())) {
            return numero;
        }
        try {
            numero = Short.parseShort(texto);
        } catch (Exception e) {
            System.out.println("[Error][FuncionNumero][nvlShort][Exception]: " + e.getMessage());
            logger.log(Level.SEVERE, "[Error][FuncionNumero][nvlShort][Exception]: {0}", e.getMessage());
            return 0;
        }
        return numero;
    }

    public static long nvlLong(String texto) {
        long numero = ((Long) (long) 0);
        if (texto == null || "".equals(texto.trim()) || "null".equals(texto.trim().toLowerCase()) || "0".equals(texto.trim())) {
            return numero;
        }
        try {
            numero = Long.parseLong(texto);
        } catch (Exception e) {
            System.out.println("[Error][FuncionNumero][parseLong][Exception]: " + e.getMessage());
            logger.log(Level.SEVERE, "[Error][FuncionNumero][parseLong][Exception]: {0}", e.getMessage());
            return ((Long) (long) 0);
        }
        return numero;
    }

    public static Double nvlDouble(String texto) {
        Double numero = 0.0;
        if (texto == null || "".equals(texto.trim()) || "null".equals(texto.trim().toLowerCase()) || "0".equals(texto.trim())) {
            return numero;
        }
        try {
            numero = Double.parseDouble(texto);
        } catch (Exception e) {
            System.out.println("[Error][FuncionNumero][nvlDouble][Exception]: " + e.getMessage());
            logger.log(Level.SEVERE, "[Error][FuncionNumero][nvlDouble][Exception]: {0}", e.getMessage());
            return numero;
        }
        return numero;
    }

    public static boolean isLong(String texto) {
        try {
            Long numero = Long.parseLong(texto);
        } catch (Exception e) {
            System.out.println("[Error][FuncionNumero][isLong][Exception]: " + e.getMessage());
            logger.log(Level.SEVERE, "[Error][FuncionNumero][isLong][Exception]: {0}", e.getMessage());
            return false;
        }
        return true;
    }

    public static boolean isBigdecimal(String texto) {
        try {
            BigDecimal numero = new BigDecimal(texto);
        } catch (Exception e) {
            System.out.println("[Error][FuncionNumero][isBigdecimal][Exception]: " + e.getMessage());
            logger.log(Level.SEVERE, "[Error][FuncionNumero][isBigdecimal][Exception]: {0}", e.getMessage());
            return false;
        }
        return true;
    }
}

package Estadistica;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author R2D2
 */
public class Estadistica {

    private static int m;

    public static double getIntervalos(int n) {
        if (n > 0) {
            double temp = 1 + (3.3 * (Math.log10(n)));
            m = (int) Math.ceil(temp);
            return temp;
        }
        m = 0;
        return 0;
    }

    public static double getMax(ArrayList<Double> datos) {
        double max, tmp;
        max = 0;
        Iterator i = datos.iterator();
        while (i.hasNext()) {
            tmp = (double) i.next();
            if (max < tmp) {
                max = tmp;
            }
        }
        return max;
    }

    public static double getMin(ArrayList<Double> datos) {
        double min, tmp;
        min = 10000000;
        Iterator i = datos.iterator();
        while (i.hasNext()) {
            tmp = (double) i.next();
            if (min > tmp) {
                min = tmp;
            }
        }
        return min;
    }

    public static int getAmplitud(double down, double up) {
        int c = (int) Math.ceil((up - down) / m);
        return c;
    }

    public static int getM() {
        return m;
    }

    public static int GetFRelativa(double yD, double yU, ArrayList<Double> datos) {
        Iterator i = datos.iterator();
        double tmp = 0;
        int count = 0;
        while (i.hasNext()) {
            tmp = (double) i.next();
            if (yD <= tmp && tmp < yU) {
                count++;
            }
        }
        return count;
    }

    public static double getFAbsoluta(double yD, double yU, ArrayList<Double> datos) {
        double fr = GetFRelativa(yD, yU, datos);
        double fa = fr / datos.size();
        return fa;
    }

    public static double getPromedio(ArrayList<Double> y, ArrayList<Integer> n) {
        int ni, nT = 0;
        double yi, suma = 0;
        for (int i = 0; i < y.size(); i++) {
            ni = n.get(i);
            yi = y.get(i);
            nT += ni;
            suma += ni * yi;
        }
        return suma / nT;
    }

    public static ArrayList<Vector> getFilasVarianza(ArrayList<Double> Y, ArrayList<Integer> n) {
        double yi, y, tmp, yiniT = 0, yiniT2 = 0, yiyniT = 0, yiyniT2 = 0;
        int ni, nt = 0;
        ArrayList<Vector> filas = new ArrayList<Vector>();
        Vector v;
        //Metodo de obtencion del promedio
        y = getPromedio(Y, n);
        //Filas para la tabla de la ventana de Varianza
        for (int i = 0; i < Y.size(); i++) {
            v = new Vector();
            yi = Y.get(i);
            v.add(yi);

            ni = n.get(i);
            nt += ni;
            v.add(ni);

            tmp = yi * ni;
            v.add(tmp);
            yiniT += tmp;

            v.add((yi - y));

            tmp = (yi - y) * ni;
            v.add(tmp);
            yiyniT += tmp;

            tmp = Math.pow((yi - y), 2) * ni;
            v.add(tmp);
            yiyniT2 += tmp;

            v.add(Math.pow(yi, 2));

            tmp = Math.pow(yi, 2) * ni;
            v.add(tmp);
            yiniT2 += tmp;

            filas.add(v);
        }
        //Fila de Sumatorias
        v = new Vector();
        v.add(" - ");
        v.add(nt);
        v.add(yiniT);
        v.add(" - ");
        v.add(Convertidor.round(yiyniT));
        v.add(yiyniT2);
        v.add(" - ");
        v.add(Convertidor.round(yiniT2));
        
        filas.add(v);
        
        return filas;
    }
    
    public double calcularPoisson(double valor){
        double auxfactorial;
        double J, Resultado;
        Resultado = 1;
        if(valor == 0){
            auxfactorial = 1;
        }
        for(J = valor;J>1;J--){
            Resultado = Resultado * J;
        }
        auxfactorial=Resultado;
        return Resultado;
    }
}

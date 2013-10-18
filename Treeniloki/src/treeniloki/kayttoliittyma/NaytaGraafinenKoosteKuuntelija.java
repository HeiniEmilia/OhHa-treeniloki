/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treeniloki.kayttoliittyma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import treeniloki.sovelluslogiikka.AjanKasittelija;
import treeniloki.sovelluslogiikka.Treeniloki;
import treeniloki.sovelluslogiikka.Urheilulaji;

/**
 *
 * @author Heini
 */
public class NaytaGraafinenKoosteKuuntelija implements ActionListener{
    private Treeniloki treeniloki;
    
    public NaytaGraafinenKoosteKuuntelija(Treeniloki treeniloki){
        this.treeniloki = treeniloki;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        DefaultCategoryDataset urheilulajienAjat = new DefaultCategoryDataset();
        for(Urheilulaji urheilulaji : treeniloki.getUrheilulajit()){
            urheilulajienAjat.addValue(urheilulaji.aikaMinuuteissa(), urheilulaji.haeAika(), urheilulaji.getNimi());
        }
        JFreeChart urheilulajiKuvaaja = ChartFactory.createBarChart("Urheilulajien ajat", "Urheilulajit", "Aika (min)", urheilulajienAjat, PlotOrientation.VERTICAL, false, true, true);
        urheilulajiKuvaaja.setBackgroundPaint(Color.WHITE);
        CategoryPlot p = urheilulajiKuvaaja.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        p.setNoDataMessage("Ei vielä urheilulajeja");
        
        ChartFrame kuvaajaFrame = new ChartFrame("Kooste urheilulajeista", urheilulajiKuvaaja);
        kuvaajaFrame.setVisible(true);
        kuvaajaFrame.setSize(450, 350);
                
    }
    
}

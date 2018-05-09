/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ermengarde
 */
public class SOM {
    private int numOutputNode = 4;
    private int numInputNode = 5;
    private ArrayList<Mahasiswa> dataPelatihan;
    private ArrayList<Mahasiswa> dataSet;
    private double learningRate;
    private int ephoc;
    private int ephocMaks;
    private double weightMatrix[][];
    private double dataPelatihanMatrix[][];
    private double dataSetMatrix[][];

    public SOM(ArrayList<Mahasiswa> dataPelatihan, double learningRate, int ephocMaks) {
        this.dataPelatihan = dataPelatihan;
        this.learningRate = learningRate;
        this.ephocMaks = ephocMaks;
        this.ephoc = 0;
        dataPelatihanMatrix = new double[dataPelatihan.size()][numInputNode];
        for(int i=0;i<dataPelatihanMatrix.length;i++){
            for(int j=0;j<dataPelatihanMatrix.length;j++){
                if(j==0){
                    dataPelatihanMatrix[i][j] = dataPelatihan.get(i).getGender();
                }
                else if(j==1){
                    dataPelatihanMatrix[i][j] = dataPelatihan.get(i).getJurusan();
                }
                else if(j==2){
                    dataPelatihanMatrix[i][j] = dataPelatihan.get(i).getHobi();
                }
                else if(j==3){
                    dataPelatihanMatrix[i][j] = dataPelatihan.get(i).getKotaAsal();
                }
                else if(j==4){
                    dataPelatihanMatrix[i][j] = dataPelatihan.get(i).getFrekuensiAkses();
                }
            }
        }
        weightMatrix = new double[numInputNode][numOutputNode];
        Random rng = new Random();
        for(int i=0;i<numInputNode;i++){
            for(int j=0;j<numOutputNode;j++){
                if(i==0){
                    weightMatrix[i][j] = 1 + (2 - 1) * rng.nextDouble();
                }
                else if(i==1){
                    weightMatrix[i][j] = 11 + (73 - 11) * rng.nextDouble();
                }
                else if(i==2){
                    weightMatrix[i][j] = 10 + (50 - 10) * rng.nextDouble();
                }
                else if(i==3){
                    weightMatrix[i][j] = 0 + (65 - 0) * rng.nextDouble();
                }
                else if(i==4){
                    weightMatrix[i][j] = 10 + (50 - 10) * rng.nextDouble();
                }
            }
        }
        this.train();
    }
    
    public ArrayList<Integer> computeDistance(){
        ArrayList<Integer> res = new ArrayList<>();
        double distTable[][] = new double[dataPelatihan.size()][numOutputNode];
        for(int i=0;i<distTable.length;i++){
            for(int j=0;j<distTable[i].length;j++){
                double dist = 0;
                for(int k=0;k<numInputNode;k++){
                    dist += Math.pow((weightMatrix[k][j]-dataPelatihanMatrix[i][k]), 2.0);
                }
                distTable[i][j] = dist;
            }
        }
        for(int i=0;i<distTable.length;i++){
            double min = Double.MAX_VALUE;
            int minIdx = 0;
            for(int j=0;j<distTable[i].length;j++){
                if(min>distTable[i][j]){
                    min = distTable[i][j];
                    minIdx = j;
                }
            }
            res.add(minIdx);
        }
        return res;
    }
    
    public ArrayList<Integer> clusterDataSet(){
        ArrayList<Integer> res = new ArrayList<>();
        double distTable[][] = new double[dataSet.size()][numOutputNode];
        for(int i=0;i<distTable.length;i++){
            for(int j=0;j<distTable[i].length;j++){
                double dist = 0;
                for(int k=0;k<numInputNode;k++){
                    dist += Math.pow((weightMatrix[k][j]-dataSetMatrix[i][k]), 2.0);
                }
                distTable[i][j] = dist;
            }
        }
        for(int i=0;i<distTable.length;i++){
            double min = Double.MAX_VALUE;
            int minIdx = 0;
            for(int j=0;j<distTable[i].length;j++){
                if(min>distTable[i][j]){
                    min = distTable[i][j];
                    minIdx = j;
                }
            }
            res.add(minIdx);
        }
        return res;
    }
    
    public void train(){
        for(int i=ephoc;i<ephocMaks;i++){
            ArrayList<Integer> minDist = computeDistance();
            for(int j=0;j<minDist.size();j++){
                for(int k=0;k<numInputNode;k++){
                    weightMatrix[k][minDist.get(j)] = weightMatrix[k][minDist.get(j)] + learningRate * (dataPelatihanMatrix[j][k]-weightMatrix[k][minDist.get(j)]);
                }
            }
            learningRate/=2;
        }
    }

    public ArrayList<Mahasiswa> getDataSet() {
        return dataSet;
    }

    public void setDataSet(ArrayList<Mahasiswa> dataSet) {
        this.dataSet = dataSet;
        dataSetMatrix = new double[dataSet.size()][numInputNode];
        for(int i=0;i<dataSetMatrix.length;i++){
            for(int j=0;j<dataSetMatrix.length;j++){
                if(j==0){
                    dataSetMatrix[i][j] = dataSet.get(i).getGender();
                }
                else if(j==1){
                    dataSetMatrix[i][j] = dataSet.get(i).getJurusan();
                }
                else if(j==2){
                    dataSetMatrix[i][j] = dataSet.get(i).getHobi();
                }
                else if(j==3){
                    dataSetMatrix[i][j] = dataSet.get(i).getKotaAsal();
                }
                else if(j==4){
                    dataSetMatrix[i][j] = dataSet.get(i).getFrekuensiAkses();
                }
            }
        }
    }

    public int getNumOutputNode() {
        return numOutputNode;
    }

    public void setNumOutputNode(int numOutputNode) {
        this.numOutputNode = numOutputNode;
    }

    public int getNumInputNode() {
        return numInputNode;
    }

    public void setNumInputNode(int numInputNode) {
        this.numInputNode = numInputNode;
    }

    public double[][] getWeightMatrix() {
        return weightMatrix;
    }

    public void setWeightMatrix(double[][] weightMatrix) {
        this.weightMatrix = weightMatrix;
    }

    public double[][] getDataPelatihanMatrix() {
        return dataPelatihanMatrix;
    }

    public void setDataPelatihanMatrix(double[][] dataPelatihanMatrix) {
        this.dataPelatihanMatrix = dataPelatihanMatrix;
    }

    public ArrayList<Mahasiswa> getDataPelatihan() {
        return dataPelatihan;
    }

    public void setDataPelatihan(ArrayList<Mahasiswa> dataPelatihan) {
        this.dataPelatihan = dataPelatihan;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public int getEphoc() {
        return ephoc;
    }

    public void setEphoc(int ephoc) {
        this.ephoc = ephoc;
    }

    public int getEphocMaks() {
        return ephocMaks;
    }

    public void setEphocMaks(int ephocMaks) {
        this.ephocMaks = ephocMaks;
    }
}

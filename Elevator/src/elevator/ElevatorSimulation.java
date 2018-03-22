/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator;

/**
 *
 * @author Debora S. Sitanggang
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//Class ElevatorSimulation sebagai Controller
public class ElevatorSimulation extends JFrame implements
ActionListener {
 JButton liftBtn[][] = new JButton[13][2];
 JButton buttonFloor [] = new JButton[13];
private JButton reset, off, on, liftY;
 private int x = 149, y = 536, yF = 536;
 int wX = 45, wY = 26;
 Timer timerLift = new Timer(20, this);
 Timer timeDoorClose = new Timer(10, this);
 Timer timeStopped = new Timer(2000, this);
 boolean liftBtnStatus[][] = new boolean[13][2];
 int currFloor = 1;
 boolean liftAct = true;
 boolean onTheWay = false;
 int countStep = 0, stoppedCount = 0;
 boolean stoppedAtDest = true;

 //Constructor
 public ElevatorSimulation() {
 setContentPane(new JLabel(new
ImageIcon(getClass().getResource("BackgroundNew2.jpg"))));
 liftBtn[0][0] = liftBtn[12][1] = null;
 liftY = new JButton();
 liftY.addActionListener(this);
 liftY.setBounds(x, y, wX, wY);
 liftY.setBackground(Color.MAGENTA);
 add(liftY);

 reset = new JButton("reset");
 reset.addActionListener(this);
 reset.setBounds(25, 535, 65, 20);
 add(reset);
 off = new JButton("off");
 off.addActionListener(this);
 off.setBounds(25, 505, 65, 20);
 add(off);
 on = new JButton("on");
 on.addActionListener(this);
 on.setBounds(25, 475, 65, 20);
 add(on);

 for (int i = 0; i < 2; i++) {
 String in [] = new String[2];
 in[i] = String.valueOf(i+1);
 buttonFloor[i] = new JButton(in[i]);
 buttonFloor[i].setBounds(295 + (60*i), 320, 50, 30);
 buttonFloor[i].addActionListener(this);
 add(buttonFloor[i]);
 }

 for (int i = 2; i < 4; i++) {
 String in [] = new String[4];
 in[i] = String.valueOf(i+1);
 buttonFloor[i] = new JButton(in[i]);
 buttonFloor[i].setBounds(295 + (60*(i-2)), 280, 50, 30);
 buttonFloor[i].addActionListener(this);
 add(buttonFloor[i]);
 }

 for (int i = 4; i < 6; i++) {
 String in [] = new String[6];
 in[i] = String.valueOf(i+1);
 buttonFloor[i] = new JButton(in[i]);
 buttonFloor[i].setBounds(295 + (60*(i-4)), 240, 50, 30);
 buttonFloor[i].addActionListener(this);
 add(buttonFloor[i]);
 }

 for (int i = 6; i < 8; i++) {
 String in [] = new String[8];
 in[i] = String.valueOf(i+1);
 buttonFloor[i] = new JButton(in[i]);
 buttonFloor[i].setBounds(295 + (60*(i-6)), 200, 50, 30);
 buttonFloor[i].addActionListener(this);
 add(buttonFloor[i]);
 }

 for (int i = 8; i < 10; i++) {
 String in [] = new String[10];
 in[i] = String.valueOf(i+1);
 buttonFloor[i] = new JButton(in[i]);
 buttonFloor[i].setBounds(295 + (60*(i-8)), 160, 50, 30);
 buttonFloor[i].addActionListener(this);
 add(buttonFloor[i]);
 }

 for (int i = 10; i < 12; i++) {
 String in [] = new String[12];
 in[i] = String.valueOf(i+1);
 buttonFloor[i] = new JButton(in[i]);
 buttonFloor[i].setBounds(295 + (60*(i-10)), 120, 50, 30);
 buttonFloor[i].addActionListener(this);
 add(buttonFloor[i]);
 }
buttonFloor[12] = new JButton("13");
 buttonFloor[12].setBounds(325, 80, 50, 30);
 buttonFloor[12].addActionListener(this);
 add(buttonFloor[12]);
for (int i = 0; i < 13; i++) {
 for (int j = 0; j < 2; j++) {
 liftBtn[i][j] = new JButton("");
 if(i != 0 && j == 0){
 liftBtn[i][j].setBounds(120, 510 - (42 * (i-1)),
13, 13);
 liftBtnStatus[i][j] = false;
 }
 if(i != 12 && j == 1){
 liftBtn[i][j].setBounds(120, 535 - (42 * (i)), 13,
13);
 liftBtnStatus[i][j] = false;
 }
 liftBtn[i][j].addActionListener(this);
 add(liftBtn[i][j]);
 }
 }
 timerLift.start();
 }

/*Method ini berfungsi mengembalikan nilai tombol yg ditekan..*/
 public int getNextFloor(){
 // Elevator bergerak keatas jika liftAct bernilai true..
 if (liftAct == true) {

 // check lantai diatas currFloor --> check tombol up
 for (int i = currFloor-1; i < 13; i++) {
 if(liftBtnStatus[i][1] == true){
 return i+1;
 }
 }

 // check lantai dibawah currFloor --> check tombol down
 for (int i = 0; i < currFloor; i++) {
 if(liftBtnStatus[i][0] == true){
// System.out.println("-> " + i+1);
 return i+1;
 }
 }

 // check lantai dibawah currFloor --> check tombol up
 for (int i = 0; i < currFloor; i++) {
 if(liftBtnStatus[i][1] == true){
 return i+1;
 }
 }

 // check tombol down
 for (int i = currFloor-1; i < 13; i++) {
 if(liftBtnStatus[i][0] == true){
     
 return i+1;
 }
 }

 } else {
 //check lantai di bawah currFloor --> cek tombol down
 for (int i = currFloor-1; i >= 0; i--) {
 if(liftBtnStatus[i][0] == true){
 return i+1;
 }
 }

 // cek tombol up
 for (int i = 0; i < 13; i++) {
 if(liftBtnStatus[i][1] == true){
 return i+1;
 }
 }

 //check tombol down
 for (int i = 0; i < 13; i++) {
 if(liftBtnStatus[i][0] == true){
 return i+1;
 }
 }

 // check tombol up
 for (int i = currFloor-1; i >= 0; i--) {
 if(liftBtnStatus[i][1] == true){
 return i+1;
 }
 }
 }
 return 0;
 }

 //Melakukan pergerakan naik..
 public void moveUp(){
 if(currFloor != 13){
 y--;
 liftY.setBounds(x, y, wX, wY);
 }
 }

 //Melakukan pergerakan turun
 public void moveDown(){
 if(currFloor != 1){
 y++;
 liftY.setBounds(x, y, wX, wY);
 }
 }
 //Memberikan aksi disetiap tindakan..
 @Override
 public void actionPerformed(ActionEvent e) {
 int nextFloor;
 //Memberi aksi pada tombol reset
 if (e.getSource() == reset) {
 setEnabledButton(true, true);
 liftY.setBounds(x, yF, wX, wY);

 //Memberi aksi pada tombol on
 } else if (e.getSource() == on) {
 setEnabledButton(true, true);
 off.setBackground(reset.getBackground());

 //Memberi aksi pada tombol off
 } else if (e.getSource() == off) {
 setEnabledButton(false, true);
 off.setBackground(Color.red);

 //Timer timeStopped
 } else if (e.getSource() == timeStopped){

 timerLift.start();

 //Timer timerLift
 } else if (e.getSource() == timerLift){
 nextFloor = getNextFloor();
 if(nextFloor > currFloor){
 liftAct = true;
 } else if(nextFloor < currFloor){
 liftAct = false;
 }
 System.out.println("Sedang Berada di Lantai -> " +
currFloor);
 if(nextFloor > 0){
 if(nextFloor != currFloor){
 stoppedAtDest = false;
if(onTheWay == false){
 countStep = 0;
stoppedCount = 0;
onTheWay = true;
 }
//Pergerakan Elevator..
if(onTheWay == true){
 countStep++;
if(liftAct){
 moveUp();
 } else {
 moveDown();
 }
//Cek currFloor
if(countStep == 42){
 if(liftAct){
 currFloor++;
 } else {
 currFloor--;
 }
onTheWay = false;
 }
 }
 } else {
 liftBtnStatus[currFloor-1][0] = false;
liftBtnStatus[currFloor-1][1] = false;
timerLift.stop();
timeStopped.start();
 }
 }
 } else {
 //Untuk memberikn aksi button up dan down di setiap lantai..
 for (int i = 0; i < 13; i++) {
 for (int j = 0; j < 2; j++) {
 if(liftBtn[i][j] == e.getSource()){
 liftBtnStatus[i][j] = true;
 }
 }
 }
 //Untuk memberikan aksi buttonFloor di setiap lantai..
 for (int i = 0; i < 13; i++) {
 if (e.getSource() == buttonFloor[i]){
 if(liftAct){
 liftBtnStatus[i][1] = true;
 }else
 liftBtnStatus[i][0] = true;
 }
 }


 }
 }

 //Method pengeset Press dan UnPress tombol..
 public void setEnabledButton(boolean seb1, boolean seb2){
 for (int i = 0; i < 13; i++) {
 for (int j = 0; j < 2; j++) {
 if(i != 0 && j == 0){
 liftBtn[i][j].setEnabled(seb1);
 }
 if(i != 12 && j == 1){
 liftBtn[i][j].setEnabled(seb1);
 }

 }
 }
 reset.setEnabled(seb2);
 off.setEnabled(seb2);
 on.setEnabled(seb2);
 }
}

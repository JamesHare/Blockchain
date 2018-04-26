package com.JamesMHare.Blockchain;

import java.util.ArrayList;

public class Main{

  public static ArrayList<Block> blockchain = new ArrayList<Block>();

  public static void main(String[] args){

    // adds new blocks to the Blockchain
    addBlock("First transaction details.");
    addBlock("Second transaction details.");
    addBlock("Third transaction details.");

    printBlockchain();

  }

  // A method to print the blockchain
  public static void printBlockchain(){
    for(int i = 0; i < blockchain.size(); i++){
      System.out.println("The hash of block "+(i+1)+" is: "+blockchain.get(i).getHash());
    }
  }

  // A method to add a new transaction to the blockchain
  public static void addBlock(String input){
    if(blockchain.size() == 0){
      blockchain.add(new Block(input, "0"));
    } else {
      blockchain.add(new Block(input, blockchain.get(blockchain.size() - 1).getHash()));
    }
  }

}

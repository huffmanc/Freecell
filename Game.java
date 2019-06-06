
/*
 * FreeCell Game
 * @author Carter Huffman, Tristan Cade, Bennett Hermann, Garrett Cannon
 *
 */

import java.util.*;

import javax.swing.*;



public class Game {
	
	private Cell[] tableaux;
	private Cell[] freeCells;
	private Cell[] homeCells;
	private Deck deck;
	
	public Game() {
		deck = new Deck();
		deck.shuffle();
		freeCells = new FreeCell[4];
		tableaux = new TableauCell[8];
		homeCells = new HomeCell[4];
		for (int i = 0; i < 4; i++) {
			freeCells[i] = new FreeCell();
			homeCells[i] = new HomeCell();
		}
		
		for (int i = 0; i < 8; i++) {
			tableaux[i] = new TableauCell();
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				Card c = deck.deal();
				c.turn();
				tableaux[j].add(c);
			}
			}
		for (int i = 0; i < 4; i++) {
			Card c = deck.deal();
			c.turn();
			tableaux[i].add(c);
		}
	}
			
	public boolean gameLost() {
		for (int i = 0; i < 4; i++) {
			if (freeCells[i].isEmpty()) {
				return false;
			}
		}
		for (Cell tab : tableaux) {
			for (Cell free : freeCells) {
				if (tab.moveFrom(free)) {
					free.moveFrom(tab);
					return false;
				}
				}
			for (Cell home : homeCells) {
				if (home.moveFrom(tab)) {
					Card card = home.remove();
					tab.add(card);
					return false;
				}
			}
			}
		int count = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i != j && tableaux[i].loserMoveFrom(tableaux[j])) {
					count += 1;
				

				}
			}
			if (count > 1) {
				
				return false;
			}
		}
		
		return true;
	}
	
	public boolean gameWon() {
		for (int i = 0; i < 4; i++) {
			if (!(homeCells[i].size() == 13)) {
				return false;
			}
		}
		return true;
	}
	
	public void reset() {
		deck = new Deck();
		deck.shuffle();
		for (int i = 0; i < 4; i++) {
			freeCells[i].clear();
			homeCells[i].clear();
		}
		for (int i = 0; i < 8; i++) {
			tableaux[i].clear();
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				Card c = deck.deal();
				c.turn();
				tableaux[j].add(c);
			}
		}
		for (int i = 0; i < 4; i++) {
			Card c = deck.deal();
			c.turn();
			tableaux[i].add(c);
		}
	}
	
	
			
	public boolean move(Cell source, Cell destination) {
		return destination.moveFrom(source);

	}
	
	public Cell getFreeCells(int i) {
		return freeCells[i];
	}
	
	public Cell getTableauCells(int i) {
		return tableaux[i];
	}
	
	public Cell getHomeCells(int i) {
		return homeCells[i];
	}

	}
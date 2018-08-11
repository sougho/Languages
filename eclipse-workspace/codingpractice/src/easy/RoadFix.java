package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


public class RoadFix {
	
	@Test
	public  void test1() {
		List<Tile> ret = findCovering(new int[] {21,22,23,24}, 3);
		printTiles(ret);
		System.out.println("----");
	}
	
	@Test
	public  void test2() {
		List<Tile> ret = findCovering(new int[] {21,22,23,25}, 3);
		printTiles(ret);
		System.out.println("----");
	}
	
	@Test
	public  void test3() {
		List<Tile> ret = findCovering(new int[] {2,4,6,8,10,12,14,16,18}, 3);
		printTiles(ret);
		System.out.println("----");
	}
	@Test
	public  void test4() {
		List<Tile> ret = findCovering(new int[] {2,4,6,8,10,12,14,16,18,20}, 3);
		printTiles(ret);
		System.out.println("----");
	}
	
	@Test
	public  void test5() {
		List<Tile> ret = findCovering(new int[] {2,4,6,8,10,12,14,16,18,20}, 5);
		printTiles(ret);
		System.out.println("----");
	}
	
	private static void printTiles(List<Tile> ret) {
		// TODO Auto-generated method stub
		for (int i = 0; i < ret.size(); i++) {
			System.out.println("Tile : " + i + " "  + ret.get(i).begin);
		}
	}

	public static List<Tile> findCovering(int[] potHoles, int k) {
		Arrays.sort(potHoles);
		int p = potHoles.length;	
		List<PotHole> phs = new ArrayList<PotHole>();
		for (int i = 0; i < p; i++) {
			phs.add(new PotHole(potHoles[i]));
		}
		List<Tile> allTiles = new ArrayList<Tile>();
		
		// First pothole - alight left of tile with 
		int floc = phs.get(0).loc;
		Tile ftile = new Tile(floc, k);
		allTiles.add(ftile);
		phs.get(0).tiles.add(ftile);
		addTileToPotHoles(phs, ftile, potHoles);
		ftile.potHoles.add(phs.get(0));
		
		for (int i = 1; i < p; i++) {
			PotHole ph = phs.get(i);
			// Place tile, as left as possible
			if (ph.tiles.size() > 0) 
			{
				//pothole alread covered - continue
				continue;
			}
			// Pothole not covered 
			// place as left as possible 
			Tile tile = new Tile (ph.loc - k + 1, k);
			allTiles.add(tile);
			addTileToPotHoles(phs, tile, potHoles);
			removeReduntantTiles(allTiles);
		}
		
		// Print the tiles 
		return allTiles;
	}
	
	private static void removeReduntantTiles(List<Tile> allTiles) {
		// TODO Auto-generated method stub
		for (int i = allTiles.size() -1; i >= 0; i--) {
			Tile t = allTiles.get(i);
			List<PotHole> phs = t.potHoles;
			boolean canBeRemoved = true;
			for (int j = 0; j < phs.size(); j++) {
				// Find if there is any pothole which is covered by only this tile
				PotHole ph = phs.get(j);
				if ((ph.tiles.size() == 1) && (ph.tiles.get(0).begin == t.begin)) {
					canBeRemoved = false;
				}
			}
			if (canBeRemoved) {
				System.out.println("removing : " + t.begin);
				allTiles.remove(t);
				for (int j = 0; j < phs.size(); j++) {
					phs.get(j).tiles.remove(t);
				}
			}
		}
		
	}

	private static void addTileToPotHoles(List<PotHole> phs, Tile tile, int [] potHoles) {
		// TODO Auto-generated method stub
		for (int i = tile.begin; i < tile.begin + tile.len; i++)
		{
			int idx = Arrays.binarySearch(potHoles, i);
			if (idx > 0 ) {
				phs.get(idx).tiles.add(tile);
				tile.potHoles.add(phs.get(idx));
			}
		}
		
	}

	static class Tile {
		List<PotHole> potHoles = new ArrayList<PotHole>();
		int begin;
		int len;
		int id;
		public Tile(int begin, int len) {
			this.begin = begin;
			this.len = len;
		}
	}
	
	static class PotHole {
		List<Tile> tiles = new ArrayList<Tile>();
		int loc;
		int id;
		public PotHole (int i) {
			loc = i;
		}
	}
	

}


package codingpractice;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import junit.framework.Assert;

public final class SterlingQueryPostProcessor {

	/**
	 * 
	 * @param orgQueryQuery
	 *            : to be postprocessed
	 * @return : Modified Query
	 * 
	 *         Removes from a given query (1=1) OR , startging from the open bracket
	 *         and ending at OR, with all whitespaces in between. Nothing else it
	 *         touched.
	 *         
	 *         Assumptions: (1=1)AND / (1!=1)OR won't come at the end 
	 *         or as the ONLY condition 
	 */

	// Patterns which needs to be eliminated
	
	public static final String[] patterns = { 
			"(.+)\\(\\s*1\\s*!\\s*=\\s*1\\s*\\)\\s*OR\\s*(.+)",
			"(.+)\\(\\s*1\\s*=\\s*1\\s*\\)\\s*AND\\s*(.+)" , 
			"(.+)\\(\\s*1\\s*!\\s*=\\s*1\\s*\\)\\s*or\\s*(.+)", 
			"(.+)\\(\\s*1\\s*=\\s*1\\s*\\)\\s*and\\s*(.+)" 
			};

	public final static String remove1neq1FromQuery(String orgQuery) {

		if (orgQuery == null)
			return null;

		Pattern pattern = null;
		Matcher matcher = null;

		for (int i = 0; i < patterns.length; i++) {
			pattern = Pattern.compile(patterns[i]);
			matcher = pattern.matcher(orgQuery);
			if (matcher.matches()) {
				if (matcher.groupCount() == 2) {
					orgQuery = matcher.group(1) + matcher.group(2);
				}
			}
		}
		return orgQuery;
	}

	@Test
	public void testRemove1neq1FromQueryWithBlanks() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((    1  !  =    1      )  OR  (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}

	@Test
	public void testRemove1neq1FromQueryWithoutBlanks() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((1!=1)OR  (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}

	@Test
	public void testRemove1neq1FromQueryPatternNotPresent() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}

	@Test
	public void testRemove1eq1FromQueryWithBlanks() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((    1    =    1      )  AND  (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}

	@Test
	public void testRemove1eq1FromQueryWithoutBlanks() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((1=1)AND  (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}

	@Test
	public void testRemove1eq1FromQueryPatternNotPresent() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}
	
	@Test
	public void testRemove1neq1FromQueryWithBlanksSmallCase() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((    1  !  =    1      )  or  (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}
	
	@Test
	public void testRemove1neq1FromQueryWithBlanksSmallCaseMultipleOrAfter() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((    1  !  =    1      )  or (a=b) or (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((a=b) or (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}
	
	@Test
	public void testRemove1neq1FromQueryWithBlanksSmallCaseMultipleOrBefore() {
		String s = remove1neq1FromQuery(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((c=d) or (    1  !  =    1      )  or (a=b) or (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE");
		System.out.println(s);
		Assert.assertEquals(
				"SELECT  /*YANTRA*/    YFS_SHIPMENT.* FROM YFS_SHIPMENT YFS_SHIPMENT     WHERE ( ((c=d) or (a=b) or (  ( YFS_SHIPMENT.SHIPMENT_KEY =  '2018081020460312345027'   )  )  ) )   ORDER BY SHIPMENT_NO ,SHIPNODE_KEY ,SELLER_ORGANIZATION_CODE",
				s);
	}
}

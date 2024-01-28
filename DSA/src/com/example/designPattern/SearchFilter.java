package com.example.designPattern;
enum SearchTypeENUM
{
	BYNAME,
	BYCATEGORY,
	BYDATE
}

class FilterTypeSearch
{
	FilterTypeSearch filterSearch;

	FilterTypeSearch(FilterTypeSearch filterSearch)
	{
		this.filterSearch = filterSearch;
	}

	void search(SearchTypeENUM searchType , String criteria)
	{
		if(filterSearch != null) filterSearch.search(searchType , criteria);
	}
}

class NameBasedFilter extends FilterTypeSearch
{
	NameBasedFilter(FilterTypeSearch filterSearch)
	{
		super(filterSearch);
	}

	public void search(SearchTypeENUM searchType , String criteria)
	{
		if(searchType == SearchTypeENUM.BYNAME)
		{
			System.out.println("Searched By Name - "+criteria);
		}
		else super.search(searchType , criteria);
	}
}

class CategoryBasedFilter extends FilterTypeSearch
{
	CategoryBasedFilter(FilterTypeSearch filterSearch)
	{
		super(filterSearch);
	}

	public void search(SearchTypeENUM searchType , String criteria)
	{
		if(searchType == SearchTypeENUM.BYCATEGORY)
		{
			System.out.println("Searched By Category - "+criteria);
		}
		else super.search(searchType , criteria);
	}
}

class DateBasedFilter extends FilterTypeSearch
{
	DateBasedFilter(FilterTypeSearch filterSearch)
	{
		super(filterSearch);
	}

	public void search(SearchTypeENUM searchType , String criteria)
	{
		if(searchType == SearchTypeENUM.BYDATE)
		{
			System.out.println("Searched By Date - "+criteria);
		}
		else super.search(searchType , criteria);
	}
}


public class SearchFilter
{
	public static void main(String[] args)
	{
		FilterTypeSearch filterObject = new FilterTypeSearch(new NameBasedFilter(new CategoryBasedFilter(new DateBasedFilter(null))));

		filterObject.search(SearchTypeENUM.BYNAME , "Abhijit");
		filterObject.search(SearchTypeENUM.BYCATEGORY , "Book");
		filterObject.search(SearchTypeENUM.BYDATE , "12/11/2023");
	}
}
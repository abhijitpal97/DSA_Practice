package com.example.designPattern;
interface XMLP
{
	void readXML();
	void parseXML();
}

class XMLParser implements XMLP
{
	public void readXML()
	{
		System.out.println("XML Read");
	}

	public void parseXML()
	{
		System.out.println("XML Parse");
	}
}

interface DocP
{
	void readDoc();
	void parseDoc();
}

class DocParser implements DocP
{
	public void readDoc()
	{
		System.out.println("Doc Read");
	}

	public void parseDoc()
	{
		System.out.println("Doc Parse");
	}
}

class Adaptor implements DocP
{
	XMLParser parser;

	Adaptor(XMLParser parser)
	{
		this.parser = parser;
	}

	public void readDoc()
	{
		parser.readXML();
	}

	public void parseDoc()
	{
		parser.parseXML();
	} 
}


public class AdaptorDesignPattern
{
	public static void main(String[] args)
	{
		XMLParser xml = new XMLParser();
		DocParser doc = new DocParser();
		DocP adap = new Adaptor(xml);

		xml.readXML();
		xml.parseXML();

		doc.readDoc();
		doc.parseDoc();

		adap.readDoc();
		adap.parseDoc();
	}
}
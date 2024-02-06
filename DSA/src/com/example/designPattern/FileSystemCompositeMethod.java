package com.example.designPattern;

import java.util.*;

interface FileSystem
{
	void ls();
}

class File implements FileSystem
{
	String filename;
	File(String filename)
	{
		this.filename = filename;
	}

	public void ls()
	{
		System.out.println("File Name - "+ filename);
	}
}

class Directory implements FileSystem
{
	String directoryName;
	List<FileSystem> fileSystems;

	Directory(String directoryName)
	{
		this.directoryName = directoryName;
		fileSystems = new ArrayList<>();
	}

	public void add(FileSystem file)
	{
		fileSystems.add(file);
	}

	public void ls()
	{
		System.out.println("Directory Name - " +directoryName);

		for(FileSystem files : fileSystems)
		{
			files.ls();
		}
	}
}

public class FileSystemCompositeMethod
{
	public static void main(String[] args)
	{
		Directory movieDir = new Directory("Movie");
		Directory learnDir = new Directory("Learn");

		FileSystem movie = new File("Hulchal");
		FileSystem movie1 = new File("Mother India");
		FileSystem learn = new File("Spark");

		movieDir.add(movie);
		movieDir.add(movie1);
		learnDir.add(learn);

		movieDir.ls();
		learnDir.ls();

	}
}
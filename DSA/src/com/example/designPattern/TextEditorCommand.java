package com.example.designPattern;
interface CommandEditor
{
	void execute();
}

interface Type
{
	void typeforward();
	void undo();
	void redo();
}

class TypeImplementer implements Type
{
	public void typeforward()
	{
		System.out.println("Type Forward");
	}

	public void undo()
	{
		System.out.println("Undo Process");
	}

	public void redo()
	{
		System.out.println("Redo Things");
	}
}

class TypeForwardCommander implements CommandEditor
{
	TypeImplementer implementer;
	TypeForwardCommander(TypeImplementer implementer)
	{
		this.implementer = implementer;
	}

	public void execute()
	{
		implementer.typeforward();
	}

}

class UndoCommander implements CommandEditor
{
	TypeImplementer implementer;
	UndoCommander(TypeImplementer implementer)
	{
		this.implementer = implementer;
	}

	public void execute()
	{
		implementer.undo();
	}

}

class RedoCommander implements CommandEditor
{
	TypeImplementer implementer;
	RedoCommander(TypeImplementer implementer)
	{
		this.implementer = implementer;
	}

	public void execute()
	{
		implementer.redo();
	}

}

class CommandImplementer implements CommandEditor
{
	CommandEditor commander;

	void setCommand(CommandEditor commander)
	{
		this.commander=commander;
	}

	public void execute()
	{
		commander.execute();
	}
}


public class TextEditorCommand
{
	public static void main(String[] args)
	{
		CommandImplementer command = new CommandImplementer();
		TypeImplementer types = new TypeImplementer();

		command.setCommand(new TypeForwardCommander(types));
		command.execute();
		command.setCommand(new TypeForwardCommander(types));
		command.execute();
		command.setCommand(new TypeForwardCommander(types));
		command.execute();
		command.setCommand(new UndoCommander(types));
		command.execute();
		command.setCommand(new RedoCommander(types));
		command.execute();
		command.setCommand(new TypeForwardCommander(types));
		command.execute();
	}
}
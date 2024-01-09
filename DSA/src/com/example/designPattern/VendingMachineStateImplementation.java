package com.example.designPattern;
enum MachineState
{
	INITIALIZE,
	INSERTMONEY,
	SELECTITEM,
	DISPANCECHANGE,
	CANCEL
}

interface VendingMachineState
{
	void initializeState();
	void insertMoneyState();
	void selectItemState();
	void dispanceItemState();
	void cancelState();
}

class VendingMachine implements VendingMachineState
{
	VendingMachineState machine;

	VendingMachine()
	{
		machine = new VendingMachineInitialze();
	}

	VendingMachineState getMachineState()
	{
		return machine;
	}

	void changeState(VendingMachineState state)
	{
		this.machine = state;
	}

	public void initializeState()
	{
		machine.initializeState();
		if(machine instanceof VendingMachineInitialze)
		{
			machine = new VendingMachineInsertMoney();
		}
	}

	public void insertMoneyState()
	{
		machine.insertMoneyState();
		if(machine instanceof VendingMachineInsertMoney)
		{
			machine = new VendingMachineSelectItem();
		}
	}
	public void selectItemState()
	{
		machine.selectItemState();
		if(machine instanceof VendingMachineSelectItem)
		{
			machine = new VendingMachineDispanceItem();
		}
	}
	public void dispanceItemState()

	{
		machine.dispanceItemState();
		if(machine instanceof VendingMachineDispanceItem)
		{
			machine = new VendingMachineCancel();
		}
	}
	public void cancelState()
	{
		{
			machine.cancelState();
			if(machine instanceof VendingMachineCancel)
			{
				machine = new VendingMachineInitialze();
			}
		}
	}
}

class VendingMachineInitialze implements VendingMachineState
{
	public void initializeState()
	{
		System.out.println("Initialze Machine");
	}
	public void insertMoneyState()
	{
		System.out.println("Can't Insert Money in Initial State");
	}
	public void selectItemState()
	{
		System.out.println("Can't Select Item in Initial State");
	}
	public void dispanceItemState()
	{
		System.out.println("Can't Dispance Item in Initial State");
	}
	public void cancelState()
	{
		System.out.println("Can't Cancel in Initial State");
	}
}

class VendingMachineInsertMoney implements VendingMachineState
{
	public void initializeState()
	{
		System.out.println("Already Machine Initialized - 1");
	}
	public void insertMoneyState()
	{
		System.out.println("Insert Money");
	}
	public void selectItemState()
	{
		System.out.println("Can't Select Item in Insert Money State");
	}
	public void dispanceItemState()
	{
		System.out.println("Can't Dispance Item in Insert Money State");
	}
	public void cancelState()
	{
		System.out.println("Can't Cancel in Insert Money State");
	}
}

class VendingMachineSelectItem implements VendingMachineState
{
	public void initializeState()
	{
		System.out.println("Already Machine Initialized - 2");
	}
	public void insertMoneyState()
	{
		System.out.println("Can't Insert Money in Select Item State");
	}
	public void selectItemState()
	{
		System.out.println("Select Item");
	}
	public void dispanceItemState()
	{
		System.out.println("Can't Dispance Item in Select Item State");
	}
	public void cancelState()
	{
		System.out.println("Can't Cancel in Select Item State");
	}
}

class VendingMachineDispanceItem implements VendingMachineState
{
	public void initializeState()
	{
		System.out.println("Already Machine Initialized - 3");
	}
	public void insertMoneyState()
	{
		System.out.println("Can't Insert Money in Dispance State");
	}
	public void selectItemState()
	{
		System.out.println("Can't Select Item in Dispance State");
	}
	public void dispanceItemState()
	{
		System.out.println("Dispance Item");
	}
	public void cancelState()
	{
		System.out.println("Can't Cancel in Dispance State");
	}
}

class VendingMachineCancel implements VendingMachineState
{
	public void initializeState()
	{
		System.out.println("Already Machine Initialized - 4");
	}
	public void insertMoneyState()
	{
		System.out.println("Can't Insert Money in Cancel State");
	}
	public void selectItemState()
	{
		System.out.println("Can't Select Item in Cancel State");
	}
	public void dispanceItemState()
	{
		System.out.println("Can't Dispance Item in Cancel State");
	}
	public void cancelState()
	{
		System.out.println("Cancel State");
	}
}

public class VendingMachineStateImplementation
{
	public static void main(String[] args)
	{
		VendingMachineState vendingMachine = new VendingMachine();
		vendingMachine.initializeState();
		vendingMachine.initializeState();
		vendingMachine.insertMoneyState();

		vendingMachine.insertMoneyState();
		vendingMachine.initializeState();

		vendingMachine.selectItemState();

		vendingMachine.initializeState();
		vendingMachine.insertMoneyState();
		vendingMachine.selectItemState();

		vendingMachine.dispanceItemState();

		vendingMachine.insertMoneyState();
		vendingMachine.dispanceItemState();

		vendingMachine.cancelState();

		vendingMachine.insertMoneyState();
	}
}
# Assignment 4 <br/>
## 1.1. User Input and Design Choice <br/>
The 5 devices are initially presented to the user along with their respective shortcut keys: <br/><br/>
**Select Device: [O] Oven -- [M] Microwave -- [D] Dishwasher -- [W] Washing Machine -- [C] Cleaning Robot**<br/><br/>
After entering a shortcut key (e.g. **O**), all active options of the specific device will appear: <br/><br/>
**Choose function: [Off] Turn Off -- [Temp] Set Temperature -- [Time] Set Timer -- [P] Set Program -- [S] Start -- [C] Check Timer -- [I] Interrupt**<br/><br/>
Then the user can again enter the shortcut key of the desired method to execute it. Anytime the user enters a key which isn't an option, the menu will start over at the first part (showing the devices again).<br/><br/>
For this task we used the Command Design Pattern as seen in the lectures. Each device implements the Device interface class except the Cleaning Robot, which implements the Device2 interface. For methods within all devices that have to use a timer, we implemented Timer Classes which extend Thread and use the method "Thread.sleep()" as a timer. Threads allow us to run a timer in parallel, so this way the user can continue to use the menu without waiting for the timer to end first. For example the Oven Class creates a instance of Timer in its startCooking() method in order to have its status isCooking to be true for the amount of time which the user entered previously in setTimer().<br/>
Whenever a method needs to check the remaining time we make use of the System.currentTimeMillis() method to calculate the time passed since starting a timer. To interrupt a Thread/Timer we used the method interrupt() which stops a current Thread.<br/>
For the last device Cleaning Robot we had to implement a second Timer class (Timer2) which has a more complex implementation as the first Timer as the Cleaning Robot has multiple Timers due to its battery life.
## 1.2. Class diagram <br/>
![class_diagram](https://github.com/davebasler/BINF4241-group-16-/blob/master/Assignment%204/ClassDiagram.PNG)


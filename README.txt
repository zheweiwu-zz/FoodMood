
*********************************************Refactoring***************************************************
Alex Vesey	- Renamed methods in the ProfileController and LoginView classes
		- Started to decompose the Databse class into smaller classes, including the Readuser Data Class	

********************************************Design Patterns************************************************
Alex Vesey
    Chain of Command Design Pattern (Object oriented design pattern)
        This design pattern is implemented in all of the View classes. For this pattern the buttons in the view class are listened for and acted upon by the controller classes. 
        This passing of command from the view to the appropriate controller that can handle the button is what creates the chain of command.
    Structured Format Pattern (UI design pattern)
        This pattern is implemented in the add food and add mood view classes. It focuses on how users enter data. The dropdown boxes are the manifestation of this design pattern.
    

Zhewei Wu	State Design Pattern (Object oriented design pattern)	This pattern was implemented in the foodmoodpair package. It was used througout the NavigationControl's mainmenu class as well.

Nada Ziab

	Good Defaults Interface Pattern - default date entry in add food and mood views
	Mediator Design Pattern - food and mood entries will be linked for relations
	
Nathan Lattig
	Factory Method Pattern (Object oriented design pattern) is implemented in the FoodController and the MoodController. For this pattern when the controller is called to create a new object it passes and integer and itself to the factory. The factory then makes a decision based on the integer of whether to return a new object or return a previously created object with the desired changes. 

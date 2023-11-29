Team: Memory Leak (Team #7)
Members: Giovanni Tran, Yeng Her, and Timothy Vu


Proposal Contributions:
Yeng Her: Helped brainstorm ideas for problems, issues, solutions, and intended usage

Timothy Vu: Help with ideas for the different sections and help write the high-level description. 

Giovanni Tran: Contributed ideas for different sections, edited the proposal, and formatted the README.md in Github.


Project Presentation Contributions:
Timothy Vu: Presented the GUI portion and did the live demo portion of the presentation.

Yeng Her: Presented the control portion and created and formatted the slides

Giovanni Tran: Presented the backend portion, inserted relevant information and code snippets in the backend part of the slides. Directed part of the live demo portion to show features such as wrong username/password input, and window scaling.


Project Code Contributions:
Giovanni Tran: Worked on the Library Backend which includes the Library, User, and Book classes. Wrote almost all of the methods for the previously mentioned classes and documentation. Wrote the exception classes and all of the test cases in the Test package. Maintained the GitHub repo containing project code. Worked on a major bug concerning the GUI when all of the components were merged together. Worked on some bugs concerning the GUI, and added code to prevent duplicate usernames in the program.

Timothy Vu: Worked on the Library Frontend, such as making the GUI pages, forms, and linking them together. Also helped a little bit with connecting the frontend with the backend such as helping display database elements on the GUI. 

Yeng Her: I combined Giovanni's code with Timothy's GUI pages for the Library Control system. I also improved and checked both the backend and frontend to blend everything seamlessly. I worked closely with my team to fix bugs.


Project Report Contributions:
Yeng Her: I filled out what I did to contribute to the project and wrote the “operations” and “steps”

Giovanni Tran: I filled out my contributions to the project and further specified the steps.

Timothy Vu: I wrote my project contributions and added more information to the problems, solutions, and functionality sections.


Problem/Issue:
Yeng Her: I had a lot of system issues and at one point had to completely switch IDE’s because of git and folder issues. There were also a lot of “holes'' in the code or areas of the frontend that didn't fit what was going on in the backend and vice versa. 

Timothy Vu: I had issues with arranging GUI buttons and other GUI elements. There were also issues with sizing the GUI elements getting them to properly register on the GUI.

Giovanni Tran: I had a problem with merging the different components of the code together. The whole team couldn’t figure out why the GUI wasn’t working when merged together. This caused the productivity of the entire team to slow down.


Solution:
Yeng Her: I learned how to work with the new IDE. I also had to edit, add, or modify some of the code provided so that either the front end fit the back end or the back end would better fit the front end. Lastly, I helped debug when needed, as putting the code together created a few issues

Timothy Vu: I decided to switch layout manager from gridbag layout to grid layout which was easier to work with. I also employed the use of a GUI builder to help arrange the buttons on the GUI properly. 

Giovanni Tran: I solved the problem by moving all of my code packages and Yeng’s controller class into the GUIPages package, this allowed the GUIPages before the merge to work as smoothly as before. This allowed work to continue for the whole team.


Functionality: 
The library has the ability to store data for users and books. It allows people to register and log in, then check out and return books. It also allows library admins to manage library databases such as adding and removing books/users. Library admins also have the ability to grant admin privileges to other users if needed for expanded administrative purposes.


Operations: 
Login Page:
Register: Enters input information into library list
Login: Searches for user information and navigates user into library upon success

Main Page:
Book Collection: Navigates User to view Library’s book collection
Logout: Returns user to log in page
(Admin exclusive) User Collection: Navigates User to view Library’s user collection

Book View:
User:
Search Books: Updates the list of books to show only books that contain input in search bar
Sort Books: Updates the list of books to show books sorted by alphabetical order
Borrow Book: Assigns book to user and changes books status
Return Book: Returns book to library and changes books status
View My Books: Updates the list of books to show books owned by the user
View All Books: Updates the list of books to show all books in library
Exit Page: Returns user to main page
Admin:
All of the above in User
Add Book: Allows Admin to add books with information entered in fields
Remove Book: Allows admin to remove books from library
Edit Book: Allows admin to rewrite book information with information entered in fields
Exit Page: Returns user to main page

User View (Admin exclusive)
Add User: Allows Admin to add users with information entered in fields
Remove User: Allows admin to remove users from library
Edit User: Allows admin to rewrite user information with information entered in fields

Steps to run the code:
To run the jar file:
Download the latest release from the Github repo.
Unzip and extract the folder.
This folder contains all files necessary to run the jar, the jar needs to be in the same directory as all other files or else it wont run correctly.
If users.txt and books.txt are not in the same directory, the program will automatically exit.
Run the jar file, if the previously mentioned instructions are followed correctly, the program should run as intended.

To compile the code:
Clone the github repository to any folder of your choosing.
Open the GUIPages file with any updated Java IDE.
If needed, specify the JDK and add class paths for JUnit testing.

Diagrams: 
https://github.com/GSTran/CS151-Library_Management_System/tree/1a1461ff667f6784c99628f7da8afaa38f395457/Diagrams

Snapshot of the running program:
Login Page

![image26](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/271b3a32-f0c7-4303-8985-edea969d0765)

Successful Registration

![image22](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/478f2647-0365-440a-b76a-cf5aaee61514)

Admin Main Screen

![image11](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/8f2003b5-2f47-40a0-bc0f-c7f8281993ec)

User Main Screen

![image25](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/4171f591-017c-4dd1-a756-1d08e4e82e05)

Logout

![image7](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/3e95b630-ae0d-4208-9a1f-d314412bdc7c)

Admin Book Screen

![image3](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/4e3ca6c7-c55f-4d46-a5f1-e915b6cc6346)

Editing (Changing BookC to BookD)

![image6](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/a34ec5d3-0682-4558-9da0-51ca54d0f0fa)

![image10](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/13b80a07-3c8d-4293-ad90-338fe8520b70)
![image15](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/995f16b6-932c-4bdb-acad-5d46d3974d27)

Adding (Adding Book E)

![image17](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/234916c1-e1e4-487a-94ca-c6ea4fbe77fc)
![image9](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/e5780ef5-1b1d-4cc9-8f8d-e7cfef177975)

Remove (Removing BookA)

![image14](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/86478245-5c60-483a-a9c1-b3490da70d7b)
![image3](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/1d023bc3-a128-4bd3-b48f-fb910573b63f)

User Book View

![image23](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/6417c3d1-91fe-4ebf-b027-2b3c73de2b2d)

Sort Books

![image13](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/38769a62-6d7f-411f-9fa1-89fd1c4b3492)

Search Book (Searching for BookD)

![image18](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/1a50f1de-f2d0-4d96-855e-29eb7d0033b6)
![image8](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/c3b1d7c8-46de-4694-88ee-79afe9d5a2b7)

Borrow Book (Borrowing BookE)

![image2](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/9c336031-78c6-48f9-9827-55c83492d1fb)
![image16](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/d1f82950-745d-4334-8526-d350b3fb7bde)

Return Book

![image19](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/f7fd6db5-475d-4f10-912e-427067539365)

View All Books

![image12](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/f6ce2557-8d9a-444e-b3f1-f7232390788f)

Admin User View Screen

![image20](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/5b905a71-74fc-4ccf-8e42-4cb8cdfc93c9)

Add User

![image5](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/02ad6b56-0711-4713-b124-d2d9195268dd)
![image1](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/2a03be5c-c243-48b4-b6c7-59c601127568)

Edit User

![image4](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/dcfe224a-72ee-4f0c-a306-628adde07596)
![image21](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/2e331eeb-468f-454f-826e-fd866fce3fcd)

Remove User

![image24](https://github.com/GSTran/CS151-Library_Management_System/assets/99845815/bccc25d8-70af-48d3-973b-dbb92e65ea2b)

_____________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
Project Proposal

• Project title
Library Management System


git• Team #, team members
Memory Leak, Giovanni Tran, Timothy Vu, Yeng Her


• Team members working on the proposal
Timothy Vu, Yeng Her, Giovanni Tran


• State the problem/issue to resolve
Managing library users and books solely through paperwork is not only laborious and inefficient but also susceptible to numerous errors throughout the process. The traditional approach consumes substantial time, requires significant effort, and relies heavily on paper documentation. Moreover, it leaves ample space for human error to creep in.
To combat this challenge, our team is dedicated to developing a Java-based library management system. The goal of this system is to automate the majority of tasks, minimizing the potential for human error. By enabling librarians to delegate much of their workload to our software, we envision a library experience that is not only more efficient and error-free but also allows them to provide their services on a greater scale with the same resources.

• If applicable, describe assumptions / operating environments / intended usage
An assumption we are going to make is that this software is made for public libraries to use. This software will also be used by library patrons and librarians on their personal computers. The intended usage of this software is for librarians to have a greater ability to manage their books as well as library patrons to have an intuitive way to check out, find, and manage their borrowed books.

• High-level description of your solution which may include (but is not limited to), your plan and approach.  Be as specific as possible
Our solution employs Java Swing to create an intuitive library management system, featuring a visually appealing interface with buttons, pictures, and labels for user-friendly navigation. To ensure data persistence, it saves and loads data in a file system. Moreover, we implement a hierarchy of classes to efficiently organize data into books and users, streamlining management and enhancing scalability.


• Functionality: describe how your solution tackles the issues
The proposed library management system boasts a range of user-centric features and administrative capabilities. Users will enjoy the flexibility to sort their books either alphabetically or by genre, enabling seamless organization of their reading materials. Additionally, they have the convenience of adding or removing books from their collection, as well as the freedom to create personalized categories such as 'wishlist' or 'finished books.' For library administrators, the system empowers them to efficiently oversee user accounts and the management of borrowed books. Furthermore, it incorporates custom exceptions to handle specific scenarios unique to library operations. To enhance data management, the system also enables libraries to serialize data into a more accessible and reusable format, streamlining the storage and retrieval of crucial information.


• Operations: List operations for each intended user (in list format).  Be precise and specific.
Library Admin:
-Add: Add books to the library for checkout
-Remove: Remove books from the library
-Add User: Add library users
-Remove User: Remove library users

Library Users:
-Check out: Check out books
-Check in: Return books
-Hold: Place a hold on a book being borrowed from another user
-Find: Find a specific book by title
-Filter: Sorts books by user-specified guidelines
-Alphabetize: Alphabetizes all books
-Author: Finds books by author
-Genre: Finds books by genre

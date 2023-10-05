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
Add: Add books to the library for checkout
Remove: Remove books from the library
Add User: Add library users
Remove User: Remove library users

Library Users:
Check out: Check out books
Check in: Return books
Hold: Place a hold on a book being borrowed from another user
Find: Find a specific book by title
Filter: Sorts books by user-specified guidelines
Alphabetize: Alphabetizes all books
Author: Finds books by author
Genre: Finds books by genre

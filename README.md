Carl Powaza

<h1>Mini-Notes</h1>
By Carl Powaza


<p>
<h2>Summary</h2>

This project is a website that is meant to be used as a light note-taking application.Users register an account,
the data is stored as an entity and is sent to MySql database that is connected using a crud repository.Once a user is registered, 
they can sign into the site.This gains them access to several more navigation bar buttons.Including add-note ,note page and user 
settings.I used thymeleaf security to set the authorization for the buttons.The ones I wanted only logged in users to see had a 
role restriction added.Then I used isAnonymous for the buttons that should only visible to non-logged in visitors. These buttons 
allow users to add notes to their page as well as edit and delete notes already in the page.The user settings allows for changing 
the password, email and other user related data.
Checking if users are able to access, or even see a certain button is handled by Spring security.This checks the role of the user
to see if they are signed in.The note page has all the users notes laid out in a grid.Each note has a title, body and buttons 
to edit or delete.Thymeleaf is used to loop over an array of notes then displaying the notes connected to the user.
</p>

 <p> 
<h2>Design Specifications</h2>
My goal for the design of the Mini-notes website was simple,
I was aiming for a lightweight dark themed site that displayed the notes clearly and without clutter.
I also wanted for the forms and notes to have a white background with dark text to give it an indented feel.
I went about doing this by using the dark on light options bootstrap provides.I also made sure to have a dark but not
black background. To ensure the site wasn’t completely gray, I created a logo that had a bit of color.Seeing it wasn’t 
enough to offset the grays, I also gave the footer a color.I chose orange as it is a nice warm color that contrasts the grays nicely.
</p>
<p>
<h2>Future Work</h2>
Currently, the only way to remove a user is to log onto the phpMyAdmin portal.
Then navigate into the user table ,search for the user and delete it from the database.
This is functional but It is not ideal.If there was a need for having multiple people that acted as admins.
I added an admin role while following the assignments but there is no difference between it and the user role. 
It would be very useful to add unique pages that allowed for functionality such as viewing , editing and deleting users.
When a user creates their account they gain access to the note page.The problem is that there is also only one page per user.
Meaning it is just a super long list of notes.In order to make the application more functional,
I would like add the ability to create and view multiple pages.Adding data to them such as Title or topic,
and allow for sorting notes between the pages.Adding functionality to the notes themselves is also a goal.right 
now they are just a list, sorted by when they are created.Allowing them to be clicked and dragged into different
orders would improve the ease of use.Having embedded images also came to mind.Having notes with an image would allow 
for even more creativity with note taking.

</p>


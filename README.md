
# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS



C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

> mainscreen.html - Lines 14 and 25: Added custom shop name to title and header

D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

> Added about.html
> mainscreen.html - Line 105: Added link to about.html
> MainScreenControllerr.java - Lines 57-58: Added mapping for about.html

E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

> BootStrapData.java - Lines 43-61: Added 5 parts
> BootStrapData.java - Lines 86-97: Added 5 products
> MainScreenControllerr.java - Lines 25-26: Connected the repository to the app

Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.


F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

> mainscreen.html - Lines 15-20 and 108-118: added styling for validation message for purchasing (fade out over 1 second)
> mainscreen.html - Line 99: added "Buy Now" button
> AddProductController.java - Line 183-201: added the mapping for the "Buy Now" button to decrement inventory if possible

G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

> Part.java - Lines 33-36: Added maxInv and minInv with @Min annotation
> Part.java - Lines 91-105: Getters and setters for maxInv and minInv
> Part.java - Lines 115-117: Added method that checks if current inv is between min and max
> InhousePart.java - Lines 27-38: Updated constructor to include maxInv and minInv; also enforced inv being between max and min
> OutsourcedPart.java - Lines 28-39: Updated constructor to include maxInv and minInv
> BootStrapData.java - Lines 46-61: Updated sample inventory to include maxInv and minInv
> AddOutsourcedPartController.java - Line 35: Fixed a bug where the abstract class was created instead of the OutsourcedPart
> InhousePartForm.html - Lines 24-38: Added maxInv and minInv fields with validation
> OutsourcedPartForm.html - Lines 25-29: Added maxInv and minInv fields with validation
> application.properties - Line 6: Renamed the repo file
> confirmationaddpart.html - Line 5: Made the redirect 1s so that the page even renders
> ValidInvRange.java - Entire file: added a new validator interface to check inventory levels against the min/max range
> InvRangeValidator.java - Entire file: implementation of the inventory validation, uses a custom error message

H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

> EnufPartsValidator.java - Line 36: Added logic so that the preexisting validator also checks to see if the inv update will put the current inventory lower than the minimum inventory
> productForm.html - Lines 40-41, 50-51, 64-65, 74-75: Added minInv and maxInv to the parts table.

I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

> InhousePartTest.java - Lines 43-60: Added three unit tests to confirm that the inventory can only be set to values between the max and min inventory values.

J.  Remove the class files for any unused validators in order to clean your code.

> Removed DeletePartsValidator.java and ValidDeleteParts.java as the current implementation is unused.
> Removed the @ValidDeleteParts annotation from Parts.java

K.  Demonstrate professional communication in the content and presentation of your submission.
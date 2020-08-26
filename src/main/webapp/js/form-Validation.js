// Wait for the DOM to be ready
$(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='saveContact']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
    	contactName: "required",
    	contactEmail: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        contactEmail: true
      },
      contactNumber: {
        required: true,
        minlength: 10
      }
    },
    // Specify validation error messages
    messages: {
      contactName: "Please enter your Name",
      contactNumber: {
        required: "Please provide your Contact Number",
        minlength: "Please provide 10-digits Contact Number"
      },
      contactEmail: "Please enter a valid email address",
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });
});
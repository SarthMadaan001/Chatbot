// DOM Elements
const addUserForm = document.getElementById('addUser  Form'); // Updated variable name
const userTableBody = document.getElementById('userTableBody');

// Event Listener for Form Submission
addUserForm.addEventListener('submit', function (event) { // Updated variable name
    event.preventDefault(); // Prevent form submission

    // Get form data
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;

    // Validate form inputs
    if (!username || !email) {
        alert('Please fill in all fields.');
        return;
    }

    if (!validateEmail(email)) {
        alert('Please enter a valid email address.');
        return;
    }

    // Add user to the table (simulated for now)
    addUserToTable(username, email); // Updated function name

    // Clear the form inputs
    addUserForm.reset(); // Updated variable name
});

// Function to validate email format
function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(String(email).toLowerCase());
}

// Function to add user to the table
function addUserToTable(username, email) { // Updated function name
    const row = document.createElement('tr');
    row.innerHTML = `
        <td>${userTableBody.children.length + 1}</td>
        <td>${username}</td>
        <td>${email}</td>
        <td>
            <button class="btn btn-danger btn-sm" onclick="deleteUser  (this)">Delete</button> <!-- Updated function name -->
        </td>
    `;
    userTableBody.appendChild(row);
}

// Function to delete a user from the table
function deleteUser  (button) { // Updated function name
    const row = button.parentElement.parentElement;
    userTableBody.removeChild(row);
}
# ATM SIMULATION WITH MULTIPLE USERS - FILE HANDLING & EXCEPTION HANDLING
# A beginner-friendly Python project for university assignment

import os

# Global variables
balance = 0
current_user = ""

# ============== FUNCTION: CHECK IF USER EXISTS ==============
def user_exists(username):
    """Check if a user folder already exists"""
    return os.path.exists(username)

# ============== FUNCTION: CREATE NEW USER ==============
def create_user(username, pin):
    """Create a new user with folder and files"""
    
    try:
        # Create folder for new user
        os.mkdir(username)
        
        # Create pin.txt with user's PIN
        with open(f"{username}/pin.txt", "w") as file:
            file.write(pin)
        
        # Create balance.txt with default balance
        with open(f"{username}/balance.txt", "w") as file:
            file.write("1000")
        
        # Create empty history.txt
        with open(f"{username}/history.txt", "w") as file:
            file.write("")
        
        print(f"✓ Account created successfully for {username}!")
        print(f"  Default balance: $1000")
        return True
    
    except Exception as e:
        print(f"Error creating user: {e}")
        return False

# ============== FUNCTION: REGISTER NEW USER ==============
def register():
    """Handle new user registration"""
    
    print("\n--- NEW USER REGISTRATION ---")
    
    try:
        # Get username
        username = input("Enter a username (no spaces): ").strip()
        
        # Validate username
        if username == "" or " " in username:
            print("✗ Invalid username. No spaces allowed and cannot be empty.")
            return None
        
        # Check if user already exists
        if user_exists(username):
            print(f"✗ Username '{username}' already exists. Please login instead.")
            return None
        
        # Get PIN
        pin = input("Create a 4-digit PIN: ").strip()
        
        # Validate PIN
        if len(pin) != 4 or not pin.isdigit():
            print("✗ PIN must be exactly 4 digits.")
            return None
        
        # Confirm PIN
        pin_confirm = input("Confirm your PIN: ").strip()
        
        if pin != pin_confirm:
            print("✗ PINs do not match. Registration failed.")
            return None
        
        # Create the user
        if create_user(username, pin):
            return username
        else:
            return None
    
    except Exception as e:
        print(f"Error during registration: {e}")
        return None

# ============== FUNCTION: LOGIN EXISTING USER ==============
def login():
    """Handle user login with username and PIN verification"""
    
    print("\n--- USER LOGIN ---")
    
    try:
        # Get username
        username = input("Enter your username: ").strip()
        
        # Check if user exists
        if not user_exists(username):
            print(f"✗ Username '{username}' not found.")
            print("  Please register first (Option 1 from main screen).")
            return None
        
        # Read the correct PIN from user's file
        with open(f"{username}/pin.txt", "r") as file:
            correct_pin = file.read().strip()
        
        # Give user 3 attempts
        attempts = 3
        
        while attempts > 0:
            entered_pin = input(f"Enter your PIN ({attempts} attempts remaining): ")
            
            if entered_pin == correct_pin:
                print(f"✓ Login Successful! Welcome back, {username}!")
                return username
            else:
                attempts -= 1
                if attempts > 0:
                    print(f"✗ Incorrect PIN. You have {attempts} attempts left.")
                else:
                    print("✗ Too many failed attempts. Session terminated.")
                    return None
    
    except Exception as e:
        print(f"Error during login: {e}")
        return None

# ============== FUNCTION: LOAD BALANCE ==============
def load_balance():
    """Load balance from user's file"""
    global balance, current_user
    
    try:
        with open(f"{current_user}/balance.txt", "r") as file:
            balance = float(file.read().strip())
    except Exception as e:
        print(f"Error loading balance: {e}")
        balance = 1000

# ============== FUNCTION: SAVE BALANCE ==============
def save_balance():
    """Save current balance to user's file"""
    global balance, current_user
    
    try:
        with open(f"{current_user}/balance.txt", "w") as file:
            file.write(str(balance))
    except Exception as e:
        print(f"Error saving balance: {e}")

# ============== FUNCTION: ADD TO HISTORY ==============
def add_to_history(transaction):
    """Add a transaction entry to user's history file"""
    global current_user
    
    try:
        with open(f"{current_user}/history.txt", "a") as file:
            file.write(transaction + "\n")
    except Exception as e:
        print(f"Error saving transaction: {e}")

# ============== FUNCTION: BALANCE INQUIRY ==============
def balance_inquiry():
    """Display current balance"""
    global balance
    
    print("\n" + "="*40)
    print(f"Your current balance is: ${balance:.2f}")
    print("="*40)

# ============== FUNCTION: DEPOSIT ==============
def deposit():
    """Handle money deposit"""
    global balance
    
    print("\n--- DEPOSIT MONEY ---")
    
    try:
        amount = float(input("Enter amount to deposit: $"))
        
        if amount <= 0:
            print("✗ Invalid amount. Please enter a positive number.")
            return
        
        # Update balance
        balance += amount
        save_balance()
        
        # Add to history
        transaction = f"Deposited ${amount:.2f}"
        add_to_history(transaction)
        
        print(f"✓ Successfully deposited ${amount:.2f}")
        print(f"New balance: ${balance:.2f}")
        
    except ValueError:
        print("✗ Invalid input. Please enter a valid number.")
    except Exception as e:
        print(f"Error during deposit: {e}")

# ============== FUNCTION: WITHDRAW ==============
def withdraw():
    """Handle money withdrawal"""
    global balance
    
    print("\n--- WITHDRAW MONEY ---")
    
    try:
        amount = float(input("Enter amount to withdraw: $"))
        
        if amount <= 0:
            print("✗ Invalid amount. Please enter a positive number.")
            return
        
        # Check if sufficient balance
        if amount > balance:
            print(f"✗ Insufficient funds. Your balance is ${balance:.2f}")
            return
        
        # Update balance
        balance -= amount
        save_balance()
        
        # Add to history
        transaction = f"Withdrew ${amount:.2f}"
        add_to_history(transaction)
        
        print(f"✓ Successfully withdrew ${amount:.2f}")
        print(f"Remaining balance: ${balance:.2f}")
        
    except ValueError:
        print("✗ Invalid input. Please enter a valid number.")
    except Exception as e:
        print(f"Error during withdrawal: {e}")

# ============== Function: Change PIN ==============
def change_pin():
    global current_user
    
    print("\n--- CHANGE PIN ---")
    
    try:
        # Read the old PIN from file
        with open(f"{current_user}/pin.txt", "r") as file:
            old_pin = file.read().strip()
        
        # Ask user to verify old PIN
        entered_old = input("Enter your current PIN: ").strip()
        
        if entered_old != old_pin:
            print("✗ Incorrect current PIN.")
            return
        
        # Enter new PIN
        new_pin = input("Enter new 4-digit PIN: ").strip()
        
        if len(new_pin) != 4 or not new_pin.isdigit():
            print("✗ New PIN must be exactly 4 digits.")
            return
        
        # Confirm PIN
        confirm_pin = input("Confirm new PIN: ").strip()
        
        if new_pin != confirm_pin:
            print("✗ PINs do not match.")
            return
        
        # Save new PIN
        with open(f"{current_user}/pin.txt", "w") as file:
            file.write(new_pin)
        
        print("✓ PIN changed successfully!")
    
    except Exception as e:
        print(f"Error changing PIN: {e}")
#=============== Funstion: Delete Account ==============
import shutil

def delete_user():
    global current_user
    
    print("\n--- DELETE ACCOUNT ---")
    print("Warning: This action cannot be undone!")
    
    try:
        # Verify user's PIN
        with open(f"{current_user}/pin.txt", "r") as file:
            correct_pin = file.read().strip()
        
        entered_pin = input("Enter your PIN to delete your account: ").strip()
        
        if entered_pin != correct_pin:
            print("✗ Incorrect PIN. Account not deleted.")
            return
        
        # Confirm delete
        confirm = input("Are you sure you want to delete your account? (yes/no): ").lower()
        
        if confirm != "yes":
            print("Account deletion cancelled.")
            return
        
        # Delete entire folder
        shutil.rmtree(current_user)
        
        print(f"✓ Account '{current_user}' deleted permanently.")
        
        # After deletion, logout user
        exit()  
    
    except Exception as e:
        print(f"Error deleting account: {e}")

# ============== FUNCTION: SHOW HISTORY ==============
def show_history():
    """Display transaction history"""
    global current_user
    
    print("\n" + "="*40)
    print("TRANSACTION HISTORY")
    print("="*40)
    
    try:
        with open(f"{current_user}/history.txt", "r") as file:
            history = file.read().strip()
            
            if history == "":
                print("No transaction history available.")
            else:
                print(history)
        
        print("="*40)
        
    except Exception as e:
        print(f"Error reading history: {e}")
        print("="*40)

# ============== FUNCTION: MAIN MENU ==============
def main_menu():
    """Display ATM menu and handle user choices"""
    global current_user
    
    while True:
        print("\n" + "="*40)
        print(f"       ATM MAIN MENU - User: {current_user}")
        print("="*40)
        print("1. Balance Inquiry")
        print("2. Deposit Money")
        print("3. Withdraw Money")
        print("4. View Transaction History")
        print("5. Change PIN")
        print("6. Delete My Account")
        print("7. Exit")
        print("="*40)
        
        try:
            choice = input("Enter your choice (1-5): ")
            
            if choice == "1":
                balance_inquiry()
            elif choice == "2":
                deposit()
            elif choice == "3":
                withdraw()
            elif choice == "4":
                show_history()
            elif choice == "5":
                change_pin()

            elif choice == "6":
                delete_user()

            elif choice == "7":
                # Exit and show session summary
                print("\n" + "="*40)
                print("SESSION SUMMARY")
                print("="*40)
                
                # Save final balance
                save_balance()
                
                # Add session end to history
                add_to_history("--- Session Ended ---")
                
                # Display final balance
                print(f"User: {current_user}")
                print(f"Final Balance: ${balance:.2f}")
                
                # Display full history
                print("\nYour Transaction History:")
                show_history()
                
                print("\n✓ Thank you for using the ATM!")
                print("  Have a great day!")
                print("="*40)
                break
            else:
                print("✗ Invalid choice. Please enter a number between 1 and 5.")
        
        except Exception as e:
            print(f"Error: {e}")
            print("Please try again.")

# ============== MAIN PROGRAM ==============
def main():
    """Main program entry point"""
    global current_user
    
    print("="*40)
    print("    WELCOME TO THE ATM SYSTEM")
    print("="*40)
    
    while True:
        print("\n--- MAIN SCREEN ---")
        print("1. Register New User")
        print("2. Login Existing User")
        print("3. Exit Program")
        
        try:
            choice = input("Enter your choice (1-3): ")
            
            if choice == "1":
                # Register new user
                username = register()
                if username:
                    current_user = username
                    load_balance()
                    main_menu()
                    break
            
            elif choice == "2":
                # Login existing user
                username = login()
                if username:
                    current_user = username
                    load_balance()
                    main_menu()
                    break
            
            elif choice == "3":
                print("\n✓ Thank you for visiting. Goodbye!")
                break
            
            else:
                print("✗ Invalid choice. Please enter 1, 2, or 3.")
        
        except Exception as e:
            print(f"Error: {e}")
            print("Please try again.")

# Run the program
if __name__ == "__main__":
    main()
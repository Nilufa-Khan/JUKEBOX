🎧 Console Jukebox: A CLI Music Player 🎧
A robust, Java-based command-line interface (CLI) music player built for performance and simplicity. Manage your local music library entirely through text commands—perfect for backend enthusiasts.


________________________________________
✨ Features
This project focuses on delivering core music player functionality via a smooth, responsive command-line experience:
•	🎹 Full Playback Control: Use simple commands to play, stop, pause, and resume audio tracks.
•	⏩ Navigation: Instantly forward or backward through tracks in your playlist.
•	🔍 Music Search: Dynamically search your loaded music directory for specific songs by title or artist.
•	📂 Playlist Management: Automatically generates a playlist from a specified local directory.
•	⚙️ Robust Backend Logic: Built purely in Java, focusing on reliable file handling and audio stream management.
________________________________________
🚀 Getting Started
To run this jukebox locally, you'll need the Java Development Kit (JDK) installed on your system.
Prerequisites
•	Java JDK (Version 11+ Recommended)
Installation
1.	Clone the repository:
bash
git clone github.com
cd YourRepoName
Use code with caution.
2.	Compile the Java source files:
bash
javac Main.java 
# (or use a build tool like Maven/Gradle if implemented)
Use code with caution.
3.	Run the application:
bash
java Main
Use code with caution.
________________________________________
🕹️ Usage
Once the application starts, you will interact with it using simple commands:
Command	Description	Example
play	Starts playing the current track	play
pause	Pauses the currently playing track	pause
resume	Resumes a paused track	resume
stop	Stops playback entirely	stop
next	Skips to the next song in the playlist	next
prev	Goes back to the previous song	prev
search	Finds a song in the library	search Bohemian Rhapsody
exit	Closes the application	exit
________________________________________
🔧 Technical Stack
•	Language: Java
•	Audio Handling: Java Sound API (javax.sound.sampled)
•	Interface: Command Line Interface (CLI)
________________________________________
💡 Learnings & Development Focus
This project was a deep dive into several key backend engineering concepts:
•	File I/O & Audio Streams: Mastering how Java interacts with the local file system and manages continuous audio data streams efficiently.
•	Concurrency: Implementing multithreading to ensure the user input listener remains active without interrupting the ongoing audio playback process.
•	OOP Principles: Applying clean Object-Oriented Programming patterns to create a modular and maintainable codebase.
________________________________________
🤝 Contributing
Contributions, issues, and feature requests are welcome! Feel free to check the issues page.
________________________________________
📄 License
This project is licensed under the MIT License.
________________________________________
Made with ❤️ and Code | © 2024 Your Name


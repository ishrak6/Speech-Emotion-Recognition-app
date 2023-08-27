# Speech-Emotion Recognition App

This repository contains a demo application that utilizes the Vokaturi API for speech emotion recognition and the Google Cloud NLP service API for text-based emotion analysis. The app offers two modes of input: voice-to-text conversion for analyzing spoken emotions and text input for analyzing emotions from typed text.

## Features

- Recognize emotions from speech using the Vokaturi API.
- Analyze emotions from text using the Google Cloud NLP service API.
- Voice-to-text conversion for spoken emotion analysis.
- Text input option is available for emotion analysis.
- User-friendly interface with a convenient recognition button.

## Getting Started

Follow these steps to set up and run the application:

### Step 1: Cloud NLP Service API Subscription

1. Go to [Cloud NLP Service API](https://cloud.google.com/natural-language/docs/samples?hl=en-us).
2. Apply for a free 12-month subscription.

### Step 2: Obtain API Key

1. Follow the instructions on the Cloud NLP Service API page to create an API Key.

### Step 3: Integrate API Key

1. In the `MainActivity.java` file, locate line `66`.
2. Replace the value of `API_KEY` with your actual API Key obtained in Step 2.

   ```java
   public static final String API_KEY = "YOUR_API_KEY_HERE";
   ```

### Step 4: Run the Application

The application should now be ready to run. You can deploy it on an Android device or emulator.

## Screenshots

Include screenshots or images of the app interface to help users understand how the app looks and functions.


## Acknowledgments

- This app utilizes the Vokaturi API for speech-emotion recognition.
- Emotional analysis from text is performed using the Google Cloud NLP service API.

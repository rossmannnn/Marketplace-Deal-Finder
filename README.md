# Marketplace Deal Finder

An Android application that scans Facebook Marketplace for good deals with intelligent filtering and deal detection.

## Features

- 🔍 **Marketplace Scanning**: Automatically scans Facebook Marketplace listings
- 🏷️ **Smart Filters**: Filter by product type, price range, and distance from your location
- 💰 **Deal Detection**: Identifies good deals based on market value analysis
- 📍 **Location-Based Search**: Find deals near you with customizable distance radius
- 📋 **Deal Lists**: View all detected deals with direct links to marketplace posts
- 💾 **Local Storage**: Save and manage your favorite deals

## Project Structure

```
Marketplace-Deal-Finder/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/rossmannnn/marketplace/
│   │   │   │   ├── ui/
│   │   │   │   ├── data/
│   │   │   │   ├── scraper/
│   │   │   │   └── model/
│   │   │   ├── res/
│   │   │   └── AndroidManifest.xml
│   │   └── test/
│   ├── build.gradle
│   └── proguard-rules.pro
├── build.gradle
├── settings.gradle
└── README.md
```

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Networking**: Retrofit + OkHttp
- **Scraping**: Jsoup
- **Local Database**: Room
- **Location**: Android Location Services
- **Async**: Coroutines

## Getting Started

### Prerequisites
- Android Studio (latest version)
- Java 11+
- Android SDK 28+

### Setup

1. Clone the repository:
```bash
git clone https://github.com/rossmannnn/Marketplace-Deal-Finder.git
cd Marketplace-Deal-Finder
```

2. Open in Android Studio:
```bash
android-studio .
```

3. Build and run:
```bash
./gradlew build
./gradlew installDebug
```

## Permissions Required

- `INTERNET` - For web scraping
- `ACCESS_FINE_LOCATION` - For distance calculations
- `ACCESS_COARSE_LOCATION` - For approximate location

## Usage

1. **Set Filters**:
   - Choose product type (Electronics, Furniture, Sports, etc.)
   - Set price range (min/max)
   - Set distance radius from your location

2. **Scan Marketplace**:
   - Tap "Start Scan" to begin searching
   - Specify number of posts to scan
   - App will analyze each listing

3. **View Deals**:
   - Sort by best price, newest, or rating
   - Tap any deal to open in Facebook Marketplace
   - Save favorites for later

## Architecture

Follows MVVM pattern:
- **Model**: Data classes and database entities
- **View**: Compose UI components
- **ViewModel**: Business logic and state management
- **Repository**: Data access layer

## Contributing

Feel free to fork and submit pull requests!

## License

MIT License - feel free to use this project for personal or commercial purposes.

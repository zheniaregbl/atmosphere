import WidgetKit

struct WeatherProvider: TimelineProvider {
    
    private let placeholderEntry = WeatherEntry(
        date: Date(),
        currenttemperature: 10
    )
    
    func placeholder(in context: Context) -> WeatherEntry {
        return placeholderEntry
    }
    
    func getSnapshot(in context: Context, completion: @escaping (WeatherEntry) -> Void) {
        completion(placeholderEntry)
    }
    
    func getTimeline(in context: Context, completion: @escaping (Timeline<WeatherEntry>) -> Void) {
        let currentDate = Date()
        let weatherEntry = WeatherEntry(date: currentDate, currenttemperature: 20)
        let timeline = Timeline(entries: [weatherEntry], policy: .atEnd)
        completion(timeline)
    }
}

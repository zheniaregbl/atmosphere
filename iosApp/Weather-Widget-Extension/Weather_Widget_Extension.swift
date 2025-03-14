import WidgetKit
import SwiftUI

@main
struct Weather_Widget_Extension: Widget {
    
    let kind = "Atmosphere weather widget"
    
    var body: some WidgetConfiguration {
        StaticConfiguration(
            kind: kind,
            provider: WeatherProvider(),
            content: { WeatherWidgetView(entry: $0) }
        )
        .configurationDisplayName("Atmosphere widget")
        .description("Some description for widget")
        .supportedFamilies([.systemMedium])
    }
}

#Preview(as: .systemMedium) {
    Weather_Widget_Extension()
} timeline: {
    WeatherEntry(date: .now, currenttemperature: 20)
    WeatherEntry(date: .now + 60, currenttemperature: 21)
}

import WidgetKit
import SwiftUI
import Foundation

struct WeatherWidgetView: View {
    
    var entry: WeatherProvider.Entry
    
    var body: some View {
        
        let dateString = { formatter in
            formatter.dateFormat = "EEE, HH:mm"
            return formatter.string(from: entry.date)
        } (DateFormatter())
        
        VStack {
            
            HStack {
                
                VStack(
                    alignment: .leading,
                    spacing: 8
                ) {
                    
                    Text(dateString)
                        .font(.title3)
                        .fontWeight(.medium)
                    
                    Text("\(entry.currenttemperature)°")
                        .font(.largeTitle)
                        .fontWeight(.semibold)
                    
                    Text("30°/10°")
                        .font(.subheadline)
                        .fontWeight(.regular)
                }
                
                Spacer()
                
                Image("fog")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .padding()
            }
            
            Spacer()
            
            Text("Click to refresh")
                .font(.caption)
        }
        .foregroundStyle(Color.white)
        .containerBackground(for: .widget) {
            Color(hue: 0, saturation: 0, brightness: 0.11)
        }
    }
}

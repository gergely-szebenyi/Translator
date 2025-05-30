//
//  LanguageDisplay.swift
//  iosApp
//
//  Created by Szebenyi Gergely on 2025. 05. 20..
//  Copyright © 2025. orgName. All rights reserved.
//

import SwiftUI
import shared

struct LanguageDisplay: View {
	var language: UiLanguage
	
	var body: some View {
		HStack {
			SmallLanguageIcon(language: language)
				.padding(.trailing, 5)
			Text(language.language.langName)
				.foregroundColor(.lightBlue)
		}
	}
}

struct LanguageDisplay_Previews: PreviewProvider {
	static var previews: some View {
		LanguageDisplay(
			language: UiLanguage(language: .german, imageName: "german")
		)
	}
}

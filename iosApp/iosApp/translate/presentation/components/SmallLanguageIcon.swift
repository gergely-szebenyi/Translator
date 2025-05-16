//
//  SmallLanguageIcon.swift
//  iosApp
//
//  Created by Szebenyi Gergely on 2025. 05. 16..
//  Copyright © 2025. orgName. All rights reserved.
//

import SwiftUI
import shared

struct SmallLanguageIcon: View {
	var language : UiLanguage
    var body: some View {
		Image(uiImage: UIImage(named: language.imageName.lowercased())!)
			.resizable()
			.frame(width: 30, height: 30)
    }
}

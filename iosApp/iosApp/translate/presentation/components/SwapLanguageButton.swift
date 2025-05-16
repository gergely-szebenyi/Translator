//
//  SwapLanguageButton.swift
//  iosApp
//
//  Created by Szebenyi Gergely on 2025. 05. 16..
//  Copyright © 2025. orgName. All rights reserved.
//

import SwiftUI

struct SwapLanguageButton: View {
	var onClick: () -> Void
    var body: some View {
		Button(action: onClick) {
			Image(uiImage: UIImage(named: "swap_languages")!)
				.padding()
				.background(Color.primaryColor)
				.clipShape(Circle())
		}
    }
}

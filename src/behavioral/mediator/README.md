# Mediator Design Pattern

Mediator tasarım deseni, nesneler arasındaki karmaşık iletişimi basitleştirmek için kullanılan davranışsal bir tasarım desenidir. Bu desen, nesneler arasındaki doğrudan iletişimi azaltır ve bir aracı (mediator) üzerinden iletişimi sağlar.

## Kullanım Amacı
- Nesneler arasındaki bağımlılıkları azaltmak
- Merkezi bir iletişim noktası sağlamak
- Kod bakımını kolaylaştırmak
- Sistemdeki coupling'i azaltmak

## Örnek Senaryo
Bu örnekte, bir chat uygulaması simüle edilmiştir. Kullanıcılar birbirleriyle doğrudan iletişim kurmak yerine, ChatMediator aracılığıyla mesajlaşırlar.
